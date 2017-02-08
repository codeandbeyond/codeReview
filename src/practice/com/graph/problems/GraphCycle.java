package practice.com.graph.problems;

import com.graph.problems.*;

public class GraphCycle {
	public boolean marked[];
	public boolean hasCycle;

	public GraphCycle(com.graph.problems.Graph G) {
		marked = new boolean[G.V()];
		for (int i = 0; i < G.V(); i++) {
			if (!marked[i]) {
				dfs(G, i, i);
			}
		}
	}

	private void dfs(com.graph.problems.Graph g, int v, int u) {
		marked[v] = true;
		for (int w : g.adj(v)) {
			if (!marked[w]) {
				dfs(g, w, v);
			} else if (w != u) {
				hasCycle = true;
			}
		}
		// TODO Auto-generated method stub

	}

	public boolean isHasCycle() {
		return hasCycle;
	}
}
