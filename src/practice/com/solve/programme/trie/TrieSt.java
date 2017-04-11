package practice.com.solve.programme.trie;

import java.io.*;
import java.util.*;

import com.trees.problems.BinaryTree;

public class TrieSt<Value> {
    private static int R = 256; // radix
    private Node root; // root of trie

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null)
            return null;
        return (Value) x.val;
    }

    private Node get(Node x, String key, int d) { // Return value associated
        // with key in the subtrie
        // rooted at x.
        if (x == null)
            return null;
        if (d == key.length())
            return x;
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) { // Change value
        // associated
        // with key if
        // in subtrie
        // rooted at x.
        if (x == null)
            x = new Node();
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new ArrayDeque<String>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    private void collect(Node x, String pre, Queue<String> q) {
        if (x == null)
            return;
        if (x.val != null)
            q.add(pre);
        for (char c = 0; c < R; c++)
            collect(x.next[c], pre + c, q);
    }

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/apatra/Powerpoint/input/JaneEyre.txt");
        TrieSt<Integer> trie = new TrieSt<Integer>();
        long trieStartTime = System.currentTimeMillis() / 1000;
        System.out.println("Start time (in Seconds) for Trie:: " + trieStartTime);
        findVowelsUsingTrie(trie, file);
        long trieEndTime = System.currentTimeMillis() / 1000;
        System.out.println("End time (in Seconds) for Trie:: " + trieEndTime);
        System.out.println(" total time taken:: for Trie" + (trieEndTime - trieStartTime));

        /*long startTime = System.currentTimeMillis() / 1000;
        System.out.println("Start time (in Seconds) for Map :: " + startTime);
        vowelsCountUsingMap(file);
        long endTime = System.currentTimeMillis() / 1000;
        System.out.println("End time (in Seconds) for Map:: " + endTime);
        System.out.println(" total time taken for Map:: " + (endTime - startTime));*/
    }

    private static void findVowelsUsingTrie(TrieSt<Integer> trie, File file) throws IOException {
     /*   BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));*/
        Scanner br = new Scanner(new FileInputStream(file));
        String line = null;

        while ((br.hasNextLine())) {
            line = br.nextLine();
            // \\s+ means any number of whitespaces between tokens
            List<String> tokens = (List) Arrays.asList(line.split("\\s+"));
            for (String word : tokens) {
                Integer numberOfVowels = getMeVowels(word.toLowerCase());
                // map.put(word, numberOfVowels);
                trie.put(word, numberOfVowels);
            }
        }
        int count = 0;
        for (String key : trie.keys()) {
            Integer val = trie.get(key);
            System.out.println(" " + key + "-->" + val);
            count = count + val;
        }
        System.out.println("-----------------------count::-----------------------" + count);

    }

    private static void vowelsCountUsingMap(File file) throws IOException {
        Map<String, Integer> map = new HashMap<String, Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line = null;
        while ((line = br.readLine()) != null) {
            int count = 0;
            // \\s+ means any number of whitespaces between tokens
            List<String> tokens = (List) Arrays.asList(line.split("\\s+"));
            for (String word : tokens) {
                Integer numberOfVowels = getMeVowels(word.toLowerCase());
                map.put(word, numberOfVowels);

            }

        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.print(" " + entry.getKey() + "-->" + entry.getValue());
        }
    }

    private static Integer getMeVowels(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o'
                    || word.charAt(i) == 'u') {
                count++;
            }
        }
        return count;
    }
}