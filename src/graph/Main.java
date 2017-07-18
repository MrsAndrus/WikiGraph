package graph;

public class Main {

	private static String DEFAULT_URL = "https://en.wikipedia.org";
	private static String GRAF_VERTEX = "wiki/Scientometrics";

	public static void main(String[] args) {
		new Root(DEFAULT_URL, GRAF_VERTEX).run();
	}
}
