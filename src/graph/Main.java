package graph;

public class Main {
	private static String WIKI_DEFAULT_URL = "https://en.wikipedia.org";
	private static String GRAF_VERTEX_DEFAULT = "/wiki/Scientometrics";
	private static String NOTION_DEFAULT = "Scientometrics";

	public static void main(String[] args) {
		String wiki_url = WIKI_DEFAULT_URL;
		String graf_vertex = GRAF_VERTEX_DEFAULT;
		String notion = NOTION_DEFAULT;

		if (args.length > 1) {
			graf_vertex = args[0];
			if (!graf_vertex.startsWith("/wiki")) {
				graf_vertex = "/wiki/" + graf_vertex;
			}
			notion = args[1];
		}
		if (args.length > 2) {
			wiki_url = args[2];
		}
		new GraphVertex(wiki_url, notion, graf_vertex).run();
	}
}
