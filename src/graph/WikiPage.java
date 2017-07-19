package graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WikiPage {
	/* wiki base address, e.g. https://en.wikipedia.org */
	private String mWikiBaseURL;
	/* current path wrt wiki base address, e.g. wiki/Science */
	private String mCurrentWikiPath;
	
	public WikiPage(String wikiBase, String current) {
		mWikiBaseURL = wikiBase;
		mCurrentWikiPath = current;
	}

	public List<Node> run() {
		List<Node> list = new ArrayList<Node>();

		System.out.println("Iterating over " + mWikiBaseURL + "/" + mCurrentWikiPath);
		try {
			Document doc = Jsoup.connect(mWikiBaseURL + "/" + mCurrentWikiPath).get();

			Elements elements = doc.body().getElementsByTag("p");
			for (Element p : elements) {
				Elements hrefs = p.select("a");
				for (Element a : hrefs) {
					if (a.attr("href").startsWith("#cite_note")) {
						/* skip references */
						continue;
					}
					Node n = new Node(a.attr("title"), mWikiBaseURL + a.attr("href"));
					list.add(n);
				}
			}
		} catch (IOException e) {
			System.out.print("Failed to retrieve " + mWikiBaseURL + "/" + mCurrentWikiPath +
					": " + e.getMessage());
			e.printStackTrace();
		}
		return list;
	}
}
