package practice.com.graph.dsnalgo;

public class DepthFirstSearch {
	public boolean[] marked;
	public int count = 0;

	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.getV()];
		dfs(G, s);

	}

	private void dfs(Graph g, int v) {
		count++;
		marked[v] = true;
		for (int w : g.adj(v)) {
			if (!marked[w]) {
				dfs(g, w);
			}
		}
	}

	public boolean marked(int v) {
		return marked[v];
	}

	public int count() {
		return count;
	}

}
