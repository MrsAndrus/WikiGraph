package graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NodeIterator {

	/* wiki base address */
	private String basePath;
	/* current path wrt wiki base address */
	private String currentPath;
	private int sourceId;
	
	public NodeIterator(String base, String current, int srcId) {
		basePath = base;
		currentPath = current;
		sourceId = srcId;
	}

	public List<Node> run() {
		List<Node> list = new ArrayList<Node>();
		
		System.out.println("Iterating over " + basePath + "/" + currentPath);
		try {
			Document doc = Jsoup.connect(basePath + "/" + currentPath).get();

			Elements elements = doc.body().getElementsByTag("p");
			for (Element p : elements) {
				Elements hrefs = p.select("a");
				for (Element a : hrefs) {
					if (a.attr("href").startsWith("#cite_note")) {
						/* skip references */
						continue;
					}
					Node n = new Node(a.attr("title"), basePath + a.attr("href"), sourceId);
					list.add(n);
				}
			}
		} catch (IOException e) {
			System.out.print("Failed to retrieve " + basePath + "/" + currentPath +
					": " + e.getMessage());
			e.printStackTrace();
		}
		return list;
	}
}
