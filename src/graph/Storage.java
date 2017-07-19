package graph;

import java.util.ArrayList;
import java.util.List;

public class Storage {
	private List<Node> mNodes;
	private List<Edge> mEdges;

	public Storage() {
		mNodes = new ArrayList<Node>();
		mEdges = new ArrayList<Edge>();
	}
}
