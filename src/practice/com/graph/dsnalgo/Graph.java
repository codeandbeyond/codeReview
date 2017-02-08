package practice.com.graph.dsnalgo;

import java.util.LinkedList;

public class Graph {
	private final int V;
	int E;
	private LinkedList<Integer>[] adj;

	Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = (LinkedList<Integer>[]) new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList();
		}
	}

	public int getV() {
		return V;
	}

	public int getE() {
		return E;
	}

	public boolean addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
		return true;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public String toString() {
		String s = V + " vertices, " + E + " edges\n";
		for (int v = 0; v < V; v++) {
			s += v + ": ";
			for (int w : this.adj(v))
				s += w + " ";
			s += "\n";
		}
		return s;
	}
}
