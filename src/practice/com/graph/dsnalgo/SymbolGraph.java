package practice.com.graph.dsnalgo;

import java.util.HashMap;
import java.util.Map;

public class SymbolGraph {
	private Map<String, Integer> map;
	private String[] keys;
	private Graph g;

	public SymbolGraph() {
		map = new HashMap<String, Integer>();
		map.put("C.bale", 0);
		map.put("Caprio", 1);
		map.put("TDKR", 2);
		map.put("Benedict", 3);
		map.put("Cavlor", 4);
		map.put("Inception", 5);
		map.put("Tom", 6);
		map.put("IronMan", 7);
		map.put("Renevant", 8);
		map.put("Robert downy", 9);
		keys = new String[map.size()];
		for (String name : map.keySet()) {
			keys[map.get(name)] = name;
		}
		g = new Graph(map.size());
		g.addEdge(map.get("Caprio"), map.get("Inception"));
		g.addEdge(map.get("Tom"), map.get("Inception"));
		g.addEdge(map.get("Tom"), map.get("Renevant"));
		g.addEdge(map.get("Robert downy"), map.get("IronMan"));
		g.addEdge(map.get("C.bale"), map.get("TDKR"));
		g.addEdge(map.get("Tom"), map.get("TDKR"));

	}

	public boolean contains(String key) {
		return map.containsKey(key);
	}

	public int index(String s) {
		return map.get(s);
	}

	public String name(int v) {
		return keys[v];
	}

	public Graph G() {
		return g;
	}
}
