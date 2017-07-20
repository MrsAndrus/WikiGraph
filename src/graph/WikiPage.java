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
	/* current wiki article wrt wiki base address, e.g. wiki/Science */
	private String mCurrentWikiArticle;
	/* base notion which must be found within the current article */
	private String mBaseNotion;
	/* this wiki page node */
	private Node mSourceNode;

	public WikiPage(String wikiBaseURL, String baseNotion, String currentArticle,
			Node sourceNode) {
		mWikiBaseURL = wikiBaseURL;
		mBaseNotion = baseNotion;
		mCurrentWikiArticle = currentArticle;
		mSourceNode = sourceNode;
	}

	public void run(Storage storage) {
		System.out.println("Iterating over " + mWikiBaseURL + mCurrentWikiArticle);
		try {
			Document doc = Jsoup.connect(mWikiBaseURL + mCurrentWikiArticle).get();

			Elements elements = doc.body().getElementsByTag("p");
			/* check if page contains base notion */
			/* FIXME: not sure if this is correct */
			String text = elements.toString();
			if (!text.toLowerCase().contains(mBaseNotion.toLowerCase())) {
				System.out.println(mBaseNotion + " not found in this page");
				return;
			}
			for (Element p : elements) {
				Elements hrefs = p.select("a");
				for (Element a : hrefs) {
					if (a.attr("href").startsWith("#cite_note")) {
						/* skip references */
						continue;
					}
					String currentTitle = a.attr("title");
					String currentArticle = a.attr("href");
					if (!currentArticle.startsWith("/wiki")) {
						/* skip non wiki links */
						continue;
					}
					if (currentArticle.contains("Special:BookSources")) {
						/* skip book ISDN links */
						continue;
					}
					System.out.println("\nNow at " + mWikiBaseURL + mCurrentWikiArticle +
							"node id = " + mSourceNode.getId());
					Node newNode = storage.addNode(mSourceNode, currentTitle, currentArticle);
					if (newNode != null) {
						WikiPage page = new WikiPage(mWikiBaseURL, mBaseNotion,
								currentArticle, newNode);
						page.run(storage);
					}
				}
			}
		} catch (IOException e) {
			System.out.print("Failed to retrieve " + mWikiBaseURL + "/" + mCurrentWikiArticle +
					": " + e.getMessage());
			e.printStackTrace();
		}
	}
}
