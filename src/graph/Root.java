package graph;

import java.util.ArrayList;
import java.util.List;

public class Root {

	protected String path;
	protected String grafVertex;

	List<Node> nodes = new ArrayList<Node>();

	public Root(String p, String vertex) {
		path = p;
		grafVertex = vertex;
	}

	public void run() {
		System.out.println("Using " + path + "/" + grafVertex + " as root URL");
		NodeIterator i = new NodeIterator(path, grafVertex, 0);
		nodes.addAll(i.run());
		for (Node n : nodes) {
			System.out.println(n.toString());
		}
	}
}
