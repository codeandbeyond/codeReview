package practice.com.graph.dsnalgo;

import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedGraph {
	private final int V;
	private int E;
	private List<Edge>[] adj;

	public EdgeWeightedGraph(int V) {
		this.V = V;

		adj = (List<Edge>[]) new List[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Edge>();
		}
	}

	public void addEdge(Edge e) {
		int v = e.getEitherVertex();
		int w = e.getOtherVertex(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}

	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	public Iterable<Edge> edges() {
		List<Edge> b = new LinkedList<Edge>();
		for (int v = 0; v < V; v++)
			for (Edge e : adj[v])
				if (e.getOtherVertex(v) > v)
					b.add(e);
		return b;
	}
}
