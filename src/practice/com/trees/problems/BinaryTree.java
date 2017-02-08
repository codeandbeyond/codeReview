package practice.com.trees.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.logging.Level;

class Node {
	Node left;
	Node right;
	int data;

	Node(int item) {
		this.data = item;
		left = right = null;
	}
}

public class BinaryTree {
	static Node root;
	static int maxLevel = 0;
	int length;
	List<Node> list = new ArrayList<Node>();
	static Node head;
	static Node prev;

	public BinaryTree(int rootData) {
		root = new Node(rootData);
		root.left = null;
		root.right = null;
	}

	public BinaryTree() {
		root = null;
	}

	public static void printInorder() {
		Node tempRoot = root;
		inorder(tempRoot);
	}

	private static void inorder(Node tempRoot) {
		if (tempRoot == null)
			return;
		inorder(tempRoot.left);
		System.out.print(tempRoot.data + " ->");
		inorder(tempRoot.right);

	}

	public static int size() {
		Node tempNode = root;
		return size(tempNode);
	}

	private static int size(Node tempNode) {
		if (tempNode == null)
			return 0;
		return (size(tempNode.left) + size(tempNode.right) + 1);
	}

	public static void levelOrderTraversalQ() {
		Node tempNode = root;
		levelOrderTraversal(tempNode);
	}

	public static void levelOrderTraversalR() {
		Node tempNode = root;
		for (int i = 1; i <= height(tempNode); i++) {
			levelOrderTraversal(tempNode, i);
			System.out.println(" ");
		}
	}

	public static int height() {
		Node tempNode = root;
		return height(tempNode);
	}

	private static int height(Node temp) {
		if (temp == null)
			return 0;
		int lheight = height(temp.left);
		int rheight = height(temp.right);
		return (lheight > rheight ? (lheight + 1) : (rheight + 1));
	}

	private static void levelOrderTraversal(Node tempNode, int level) {
		if (tempNode == null)
			return;
		if (level == 1) {
			System.out.print(tempNode.data + " ");
		}
		if (level > 1) {
			levelOrderTraversal(tempNode.left, level - 1);
			levelOrderTraversal(tempNode.right, level - 1);
		}
	}

	private static void levelOrderTraversal(Node tempNode) {
		if (tempNode == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(tempNode);
		while (true) {
			int nodeCount = queue.size();
			if (nodeCount == 0)
				break;
			while (nodeCount > 0) {
				Node temp = queue.remove();
				System.out.print(" " + temp.data);
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
				nodeCount--;
			}
			System.out.println(" ");
		}

	}

	public static void inOrderWithoutRecursion() {
		Node tempNode = root;
		inOrderWithoutRecursion(tempNode);
	}

	public static void morrisTraversal() {
		Node temp = root;
		morrisTraversal(temp);
	}

	private static void morrisTraversal(Node node) {
		if (node == null)
			return;
		Node pre;
		Node current = node;
		while (current != null) {
			if (current.left == null) {
				System.out.println(" " + current.data);
				current = current.right;
			} else {
				pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} else {
					pre.right = null;
					System.out.println(" " + current.data);
					current = current.right;
				}
			}
		}
	}

	private static void inOrderWithoutRecursion(Node tempNode) {
		if (tempNode == null)
			return;
		Stack<Node> stack = new Stack<Node>();
		while (tempNode != null) {
			stack.push(tempNode);
			tempNode = tempNode.left;
		}
		while (stack.size() > 0) {
			Node temp = stack.pop();
			System.out.print(" " + temp.data);
			if (temp.right != null) {
				temp = temp.right;
				while (temp != null) {
					stack.push(temp);
					temp = temp.left;
				}
			}
		}
	}

	public static void rightView() {
		Node temp = root;
		rightView(temp, 1);
	}

	private static void rightView(Node node, int level) {

		if (node == null)
			return;
		if (level > maxLevel) {
			System.out.print(" " + node.data);
			maxLevel = level;
		}
		rightView(node.right, level + 1);
		rightView(node.left, level + 1);
	}

	public static void mirror() {
		Node temp = root;
		mirror(temp);
	}

	private static void mirror(Node node) {
		if (node == null)
			return;
		mirror(node.left);
		mirror(node.right);
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	public void printLeafPath() {
		Node node = root;
		printLeafPath(node, 0);
	}

	private void printLeafPath(Node node, int path) {

		if (node == null)
			return;
		list.add(path, node);
		path = path + 1;
		if (node.left == null && node.right == null) {
			printPaths(list, path);

			System.out.println(" ");
			return;
		}

		printLeafPath(node.left, path);
		printLeafPath(node.right, path);
	}

	private static void printPaths(List<Node> list, int length) {
		for (int i = 0; i < length; i++)
			System.out.print(" " + list.get(i).data);

	}

	public static void binaryTreeToDll() {
		Node node = root;

		Node head = binaryTreeToDLL(node);
		while (head.left != null) {
			head = head.left;
		}
		while (head != null) {
			System.out.print(" " + head.data);
			head = head.right;
		}
	}

	public static Node binaryTreeToDLL(Node node) {
		if (node == null) {
			return node;
		}
		if (node.left != null) {
			Node left = binaryTreeToDLL(node.left);
			for (; left.right != null;)
				left = left.right;
			left.right = node;
			node.left = left;
		}
		if (node.right != null) {
			Node right = binaryTreeToDLL(node.right);
			for (; right.left != null;)
				right = right.left;
			right.left = node;
			node.right = right;
		}
		return node;
	}

}
