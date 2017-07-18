package graph;

public class Node {
	private static int nextId = 1;
	private String title;
	private String href;
	private int id;
	private int sourceId;
	
	public Node(String t, String hRef, int srcId) {
		id = nextId++;
		title = t;
		href = hRef;
		sourceId = srcId;
	}
	
	public String toString() {
		return "id = " + id + " sourceId " + sourceId + " \"" +
				title + "\" " + href;
	}
}
