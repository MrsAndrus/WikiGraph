package graph;

import java.util.ArrayList;
import java.util.List;

public class Root {

	protected String mPath;
	protected String mGrafVertex;

	List<String> mTags = new ArrayList<String>();

	public Root(String path, String node) {
		mPath = path;
		mGrafVertex = node;
	}

	public void run() {
		System.out.print("Using " + mPath + "/" + mGrafVertex + " as root URL");
//		Document doc = Jsoup.connect("http://daniweb.com/").get();
	}
}
