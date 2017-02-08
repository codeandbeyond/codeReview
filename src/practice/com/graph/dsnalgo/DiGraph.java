package practice.com.graph.dsnalgo;

import java.util.LinkedList;

public class DiGraph {
	private final int V;
	int E;
	private LinkedList<Integer>[] adj;

	DiGraph(int V) {
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

	public DiGraph reverse() {
		DiGraph R = new DiGraph(V);
		for (int v = 0; v < V; v++) {
			for (int w : R.adj(v)) {
				R.addEdge(w, v);
			}
		}

		return R;
	}

}
