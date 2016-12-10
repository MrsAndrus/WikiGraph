package graph;

public class Main {

	private static String DEFAULT_URL = "https://en.wikipedia.org/wiki/";
	private static String GRAF_VERTEX = "Scientometrics";

	public static void main(String[] args) {
		new Root(DEFAULT_URL, GRAF_VERTEX).run();
	}
}
