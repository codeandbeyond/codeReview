package practice.com.graph.problems;

import com.graph.problems.*;

public class DiGraphMain {
	public static void main(String[] args) {
		com.graph.problems.DiGraph g = new com.graph.problems.DiGraph(10);
		g.addEdge(0, 2);
		g.addEdge(2, 4);
		g.addEdge(0, 3);
		g.addEdge(3, 5);
		g.addEdge(5, 4);
		g.addEdge(5, 6);
		g.addEdge(6, 7);
		g.addEdge(7, 8);
		g.addEdge(8, 9);
		g.addEdge(0, 1);
		for (int v = 0; v < g.V(); v++) {
			System.out.println(v + " " + g.adj(v));
		}
	}
}
