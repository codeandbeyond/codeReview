package practice.com.graph.problems;

import com.graph.problems.*;

import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedGraph {
	private final int V; // number of vertices
	private int E; // number of edges
	private List<com.graph.problems.Edge>[] adj; // adjacency lists

	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (List<com.graph.problems.Edge>[]) new List[V];
		for (int v = 0; v < V; v++)
			adj[v] = new LinkedList<com.graph.problems.Edge>();
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(com.graph.problems.Edge e) {
		int v = e.either(), w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}

	public Iterable<com.graph.problems.Edge> adj(int v) {
		return adj[v];
	}

	public Iterable<com.graph.problems.Edge> edges() {
		List<com.graph.problems.Edge> b = new LinkedList<com.graph.problems.Edge>();
		for (int v = 0; v < V; v++)
			for (com.graph.problems.Edge e : adj[v])
				if (e.other(v) > v)
					b.add(e);
		return b;
	}
}
