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

			Elements elements = doc.body().select("p");
			for (Element p : elements) {
				System.out.println("---------------------------------------");
				while (p.tagName().equals("p")) {
					Elements hrefs = p.select("a");

					for (Element a : hrefs) {
						System.out.println(a.toString());
						System.out.println("Title: \"" + a.attr("title") + "\"");
						System.out.println("href: " + a.attr("href"));
					}
					/*
					for (Element link : hrefs) {
						System.out.println(link.attr("href"));
					}
					*/
					p = p.nextElementSibling();
				}
			}
		} catch (IOException e) {
			System.out.print("Failed to retrieve " + mPath + "/" + mGrafVertex
					+ ": " + e.getMessage());
			e.printStackTrace();
		}
	}
}
