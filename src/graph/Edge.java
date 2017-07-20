package graph;

public class Edge {
	private int mSourceId;
	private int mTargetId;

	public Edge(int source, int target) {
		mSourceId = source;
		mTargetId = target;
		System.out.println("Add edge " + toString());
	}

	public int getSource() {
		return mSourceId;
	}

	public int getTarget() {
		return mTargetId;
	}

	public String toString() {
		return "source = " + mSourceId + " target = " + mTargetId;
	}
}
