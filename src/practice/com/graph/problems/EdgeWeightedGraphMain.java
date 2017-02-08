package practice.com.graph.problems;

import com.graph.problems.*;
import com.graph.problems.Edge;

import java.util.Collections;
import java.util.List;

public class EdgeWeightedGraphMain {
	public static void main(String[] args) {
		com.graph.problems.Edge edge = new com.graph.problems.Edge(0, 1, 10);
		com.graph.problems.Edge edge1 = new com.graph.problems.Edge(1, 2, 5);
		com.graph.problems.Edge edge2 = new com.graph.problems.Edge(2, 3, 7);
		com.graph.problems.Edge edge3 = new com.graph.problems.Edge(3, 5, 4);
		com.graph.problems.Edge edge4 = new com.graph.problems.Edge(4, 5, 6);
		com.graph.problems.Edge edge5 = new com.graph.problems.Edge(7, 8, 10);
		com.graph.problems.EdgeWeightedGraph ewg = new com.graph.problems.EdgeWeightedGraph(10);
		ewg.addEdge(edge);
		ewg.addEdge(edge1);
		ewg.addEdge(edge2);
		ewg.addEdge(edge3);
		ewg.addEdge(edge4);
		ewg.addEdge(edge5);
		Collections.sort((List<com.graph.problems.Edge>) ewg.edges());
		for (Edge w : ewg.edges()) {
			System.out.println(w);
		}
	}
}
