package graph;

public class Node {
	private static int mNextId = 0;
	private String mTitle;
	private String mURL;
	private int mId;

	public Node(String title, String href) {
		mId = mNextId++;
		mTitle = title;
		mURL = href;
		System.out.println("Add node " + toString());
	}

	public String getURL() {
		return mURL;
	}

	public int getId() {
		return mId;
	}

	public int getNextId() {
		return mId;
	}

	public String toString() {
		return "id = " + mId + " \"" +  mTitle + "\" " + mURL;
	}
}
