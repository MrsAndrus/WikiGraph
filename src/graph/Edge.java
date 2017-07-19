package graph;

public class Edge {
	private int mSourceId;
	private int mTargetId;

	public Edge(int source, int target) {
		mSourceId = source;
		mTargetId = target;
	}

	public String toString() {
		return "source = " + mSourceId + " target = " + mTargetId;
	}
}
