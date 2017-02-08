package practice.com.graph.dsnalgo;

public class DiGraphMain {
	public static void main(String[] args) {
		DiGraph dg = new DiGraph(10);
		dg.addEdge(0, 2);
		dg.addEdge(0, 3);
		dg.addEdge(0, 4);
		dg.addEdge(1, 2);
		dg.addEdge(2, 3);
		dg.addEdge(4, 5);
		dg.addEdge(5, 6);
		dg.addEdge(6, 7);
		dg.addEdge(8, 9);
		dg.addEdge(7, 4);
		DirectedCycle dc = new DirectedCycle(dg);
		System.out.println(" " + dg);
		System.out.println("Is there a cycle?? " + dc.hasCycle());
		
		for (int x : dc.cycle()) {
			System.out.print(" " + x);
		}
	}
}
