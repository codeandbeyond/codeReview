package practice.com.graph.dsnalgo;

public class GraphApplication {
	public static void main(String[] args) {
		Graph g = new Graph(10);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(0, 4);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(4, 5);
		g.addEdge(5, 6);
		g.addEdge(6, 7);
		g.addEdge(8, 9);

		int s = 0;

		/*
		 * DepthFirstSearch search = new DepthFirstSearch(g, s); for (int v = 0;
		 * v < g.getV(); v++) if (search.marked(v)) System.out.print(v + " ");
		 * System.out.println(); if (search.count() != g.getV())
		 * System.out.print("NOT "); System.out.println("connected")
		 */;
		Paths search = new Paths(g, s);
		for (int v = 0; v < g.getV(); v++) {
			System.out.println(s + " to " + v + ": ");
			if (search.hasPathTo(v)) {
				for (int x : search.pathTo(v)) {
					System.out.print("-" + x);
				}
			}
			System.out.println("");
		}
		SymbolGraph sg = new SymbolGraph();
		Graph G = sg.G();
		String actor = "Tom";
		int v = sg.index(actor);
		for (int w : G.adj(v)) {
			System.out.println("  " + sg.name(w));
		}
	}
}
