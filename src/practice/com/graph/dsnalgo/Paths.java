package practice.com.graph.dsnalgo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Paths {
	public boolean[] marked;
	public int[] edgeTo;
	int s;

	public Paths(Graph G, int s) {
		this.s = s;
		marked = new boolean[G.getV()];
		edgeTo = new int[G.getV()];
		dfs(G, s);

	}

	private void dfs(Graph g, int v) {
		marked[v] = true;
		for (int w : g.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(g, w);
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		/* Queue<Integer> path = new LinkedList<Integer>(); */
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}
}
