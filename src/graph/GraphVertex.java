package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphVertex {
	/* wiki base address, e.g. https://en.wikipedia.org */
	private String mWikiBaseURL;
	/* current wiki article wrt wiki base address, e.g. wiki/Science */
	private String mCurrentWikiArticle;
	/* base notion which must be found within the current article */
	private String mBaseNotion;
	private Storage mStorage;

	public GraphVertex(String wikiBase, String baseNotion, String current) {
		mWikiBaseURL = wikiBase;
		mBaseNotion = baseNotion;
		mCurrentWikiArticle = current;
		mStorage = new Storage();
	}

	public void run() {
		System.out.println("Using " + mWikiBaseURL + "/" +
				mCurrentWikiArticle + " as root URL, base notion is " +
				mBaseNotion);
		Node initialNode = mStorage.addNode(null, mBaseNotion, mCurrentWikiArticle);
		WikiPage page = new WikiPage(mWikiBaseURL, mBaseNotion, mCurrentWikiArticle, initialNode);
		page.run(mStorage);
	}
}
