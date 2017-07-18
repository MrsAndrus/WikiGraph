package graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Root {

	protected String mPath;
	protected String mGrafVertex;

	List<String> mTags = new ArrayList<String>();

	public Root(String path, String node) {
		mPath = path;
		mGrafVertex = node;
	}

	public void run() {
		System.out.println("Using " + mPath + "/" + mGrafVertex + " as root URL");
		try {
			Document doc = Jsoup.connect(mPath + "/" + mGrafVertex).get();

			Elements elements = doc.body().getElementsByTag("p");
			for (Element p : elements) {
				System.out.println("---------------- Next paragraph -----------------------");

				Elements hrefs = p.select("a");
				for (Element a : hrefs) {
					if (a.attr("href").startsWith("#cite_note")) {
						/* skip references */
						continue;
					}
					System.out.println("Title: \"" + a.attr("title") + "\"");
					System.out.println("href: " + a.attr("href"));
				}
			}
		} catch (IOException e) {
			System.out.print("Failed to retrieve " + mPath + "/" + mGrafVertex
					+ ": " + e.getMessage());
			e.printStackTrace();
		}
	}
}
