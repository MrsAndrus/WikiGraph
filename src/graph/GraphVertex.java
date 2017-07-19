package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphVertex {
	/* wiki base address, e.g. https://en.wikipedia.org */
	private String mWikiBaseURL;
	/* current path wrt wiki base address, e.g. wiki/Science */
	private String mCurrentWikiPath;
	private Storage mStorage;

	public GraphVertex(String wikiBase, String current) {
		mWikiBaseURL = wikiBase;
		mCurrentWikiPath = current;
		mStorage = new Storage();
	}

	public void run() {
		System.out.println("Using " + mWikiBaseURL + "/" +
				mCurrentWikiPath + " as root URL");
		WikiPage page = new WikiPage(mWikiBaseURL, mCurrentWikiPath);
		List<Node> nodes = page.run();
		for (Node n : nodes) {
			System.out.println(n.toString());
		}
	}
}
