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

	/*
	 * Look up or add a node:
	 *  - return true if node has not been found and added to the list
	 *    this means that we must continue parsing pages
	 *  - return false if node exists, just add edge
	 */
	public Node addNode(Node sourceNode, String title, String href) {
		for (Node i : mNodes) {
			if (i.getURL().equals(href)) {
				/* found in the storage, add edge */
				System.out.println("Node found in the storage: " + href);
				mEdges.add(new Edge(sourceNode.getId(), i.getId()));
				return null;
			}
		}
		/* node not found, add new */
		System.out.println("Node NOT found in the storage: " + href);
		Node newNode = new Node(title, href);
		mNodes.add(newNode);
		if (sourceNode != null) {
			mEdges.add(new Edge(sourceNode.getId(), newNode.getId()));
		}
		return newNode;
	}
}
