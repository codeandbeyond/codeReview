package practice.com.trees.problems;

import com.trees.problems.*;
import com.trees.problems.BinaryTree;

public class BinaryTreeApplication {
	public static void main(String[] args) {
		com.trees.problems.BinaryTree tree = new com.trees.problems.BinaryTree();
		tree.root = new com.trees.problems.Node(50);
		tree.root.left = new com.trees.problems.Node(25);
		tree.root.right = new com.trees.problems.Node(75);
		tree.root.left.left = new com.trees.problems.Node(100);
		tree.root.left.right = new com.trees.problems.Node(150);
		tree.root.right.left = new com.trees.problems.Node(200);
		tree.root.right.right = new com.trees.problems.Node(250);
		com.trees.problems.BinaryTree.printInorder();
		System.out.println(" ");
		System.out.println("Size of Tree " + com.trees.problems.BinaryTree.size());
		System.out.println("Height of Tree " + com.trees.problems.BinaryTree.height());
		com.trees.problems.BinaryTree.levelOrderTraversalQ();// Iterative
		com.trees.problems.BinaryTree.levelOrderTraversalR();// Recursive
		System.out.println("Inorder Without recursion");
		com.trees.problems.BinaryTree.inOrderWithoutRecursion();
		com.trees.problems.BinaryTree.morrisTraversal();
		System.out.println("Right View of Binary tree is");
		com.trees.problems.BinaryTree.rightView();
		//BinaryTree.mirror();
		com.trees.problems.BinaryTree.levelOrderTraversalQ();
		tree.printLeafPath();
BinaryTree.binaryTreeToDll();
	}
}
