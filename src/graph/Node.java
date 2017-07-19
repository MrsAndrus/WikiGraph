package graph;

public class Node {
	private static int mNextId = 1;
	private String mTitle;
	private String mURL;
	private int mId;

	public Node(String title, String href) {
		mId = mNextId++;
		mTitle = title;
		mURL = href;
	}

	public String toString() {
		return "id = " + mId + " \"" +  mTitle + "\" " + mURL;
	}
}
