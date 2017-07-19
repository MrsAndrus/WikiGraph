package graph;

public class Main {
	private static String WIKI_DEFAULT_URL = "https://en.wikipedia.org";
	private static String GRAF_VERTEX_DEFAULT = "wiki/Scientometrics";

	public static void main(String[] args) {
		new GraphVertex(WIKI_DEFAULT_URL, GRAF_VERTEX_DEFAULT).run();
	}
}
