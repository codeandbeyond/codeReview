package com.trees.problems;

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
	private static Node root;

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

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(50);
		tree.root.left = new Node(25);
		tree.root.right = new Node(75);
		tree.root.left.left = new Node(100);
		tree.root.left.right = new Node(150);
		tree.root.right.left = new Node(200);
		tree.root.right.right = new Node(250);
		printInorder();
		System.out.println(" ");
		System.out.println("Size of Tree " + BinaryTree.size());
	}
}
