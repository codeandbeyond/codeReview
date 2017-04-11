import java.util.*;

public class PowerOutage {
    public int estimateTimeOut(int[] fromJunction, int[] toJunction, int[] ductLength) {
        EdgeWeightedGraph egw = new EdgeWeightedGraph(toJunction[toJunction.length-1]+1);
        int sumOflength = 0;
        int longestLength = 0;
        for (int length : ductLength) {
            sumOflength += length;
        }
        longestLength = getLongestLength(fromJunction, toJunction, ductLength, egw);
        return 2 * sumOflength - longestLength;
    }

    private int getLongestLength(int[] fromJunction, int[] toJunction, int[] ductLength, EdgeWeightedGraph egw) {
        for (int i = 0; i < ductLength.length; i++) {
            Edge edge = new Edge(fromJunction[i], toJunction[i], ductLength[i]);
            egw.addEdge(edge);
        }
        return getMaxLength(egw, 0);
    }

    private int getMaxLength(EdgeWeightedGraph egw, int i) {
        int max = 0;
        for (Edge edge : egw.adj(i)) {
            double weight = edge.weight() + getMaxLength(egw, edge.other(i));
            if (weight > max) {
                max = (int) weight;
            }
        }
        return max;
    }


}

class EdgeWeightedGraph {
    private final int V; // number of vertices
    private int E; // number of edges
    private List<Edge>[] adj; // adjacency lists

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<Edge>[]) new List[V];
        for (int v = 0; v < V; v++)
            adj[v] = new LinkedList<Edge>();
    }
    public void addEdge(Edge e) {
        int v = e.either();
        adj[v].add(e);
        //adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
}

class Edge {
    private final int v; // one vertex
    private final int w; // the other vertex
    private final double weight; // edge weight

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if (vertex == v)
            return w;
        else if (vertex == w)
            return v;
        else
            throw new RuntimeException("Inconsistent edge");
    }
}
