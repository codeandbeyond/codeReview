package practice.com.graph.dsnalgo;

import java.util.Stack;

public class DirectedCycle {
	private boolean[] marked;
	private int[] edgeTo;
	private boolean[] onStack;
	private Stack<Integer> cycle;

	public DirectedCycle(DiGraph g) {
		marked = new boolean[g.getV()];
		edgeTo = new int[g.getV()];
		onStack = new boolean[g.getV()];
		for (int v = 0; v < g.getV(); v++) {
			if (!marked[v]) {
				dfs(g, v);
			}
		}
	}

	private void dfs(DiGraph g, int v) {
		marked[v] = true;
		onStack[v] = true;
		for (int w : g.adj(v)) {
			if (this.hasCycle()) {
				return;
			} else if (!marked[w]) {
				edgeTo[w] = v;
				dfs(g, w);
			} else if (onStack[w]) {
				cycle = new Stack<Integer>();
				for (int x = v; x != w; x = edgeTo[x])
					cycle.push(x);
				cycle.push(w);
				cycle.push(v);

			}
			onStack[w] = false;
		}

	}

	public boolean hasCycle() {
		// TODO Auto-generated method stub
		return cycle != null;
	}

	public Iterable<Integer> cycle() {
		return cycle;
	}
}
