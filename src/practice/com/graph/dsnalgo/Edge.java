package practice.com.graph.dsnalgo;

public class Edge implements Comparable<Edge> {
	private final int v;
	private final int w;
	private final double weight;

	Edge(int v, int w, int weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;

	}

	public int getV() {
		return v;
	}

	public int getW() {
		return w;
	}

	public double getWeight() {
		return weight;
	}

	public int getEitherVertex() {
		return v;
	}

	public int getOtherVertex(int vertex) {
		return (vertex == v) ? w : v;
	}

	@Override
	public int compareTo(Edge that) {
		if (this.weight > that.weight)
			return 1;
		else if (this.weight < that.weight)
			return -1;
		else
			return 0;

	}

}
