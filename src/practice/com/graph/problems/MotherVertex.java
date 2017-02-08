package practice.com.graph.problems;


import com.graph.problems.*;

public class MotherVertex {
	public boolean marked[];
	private int motherVertex;
	private com.graph.problems.Graph g;

	public MotherVertex(com.graph.problems.Graph G) {
		this.g = G;
		marked = new boolean[G.V()];
		for (int i = 0; i < G.V(); i++) {
			if (!marked[i]) {
				dfs(G, i);
				motherVertex = i;
			}
		}
		marked = new boolean[g.V()];
	}

	private void dfs(com.graph.problems.Graph g, int v) {
		marked[v] = true;
		for (int w : g.adj(v)) {
			if (!marked[w]) {
				dfs(g, w);
			}
		}
		// TODO Auto-generated method stub

	}

	public boolean isMotherVertex() {

		dfs(g, getMothVertex());
		for (int v = 0; v < g.V(); v++) {
			if (!marked[v]) {
				return false;
			}
		}
		return true;
	}

	public int getMothVertex() {
		return motherVertex;
	}

}
