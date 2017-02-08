package practice.com.gfg.dsnalgo;

//Java program to convert binary tree to double linked list

//A binary tree node
class NodeTree {

 int data;
 NodeTree left, right;

 NodeTree(int item) {
     data = item;
     left = right = null;
 }
}

class BinaryTreeToDll {

 static NodeTree root;
 /* This is the core function to convert Tree to list. This function follows
  steps 1 and 2 of the above algorithm */

 NodeTree bintree2listUtil(NodeTree node) {
      
     // Base case
     if (node == null) {
         return node;
     }

     // Convert the left subtree and link to root
     if (node.left != null) {
          
         // Convert the left subtree
         NodeTree left = bintree2listUtil(node.left);

         // Find inorder predecessor. After this loop, left
         // will point to the inorder predecessor
         for (; left.right != null; left = left.right);

         // Make root as next of the predecessor
         left.right = node;

         // Make predecssor as previous of root
         node.left = left;
     }

     // Convert the right subtree and link to root
     if (node.right != null) {
          
         // Convert the right subtree
         NodeTree right = bintree2listUtil(node.right);

         // Find inorder successor. After this loop, right
         // will point to the inorder successor
         for (; right.left != null; right = right.left);

         // Make root as previous of successor
         right.left = node;

         // Make successor as next of root
         node.right = right;
     }

     return node;
 }

 // The main function that first calls bintree2listUtil(), then follows step 3 
 //  of the above algorithm
  
 NodeTree bintree2list(NodeTree node) {
      
     // Base case
     if (node == null) {
         return node;
     }

     // Convert to DLL using bintree2listUtil()
     node = bintree2listUtil(node);

     // bintree2listUtil() returns root node of the converted
     // DLL.  We need pointer to the leftmost node which is
     // head of the constructed DLL, so move to the leftmost node
     while (node.left != null) {
         node = node.left;
     }

     return node;
 }

 /* Function to print nodes in a given doubly linked list */
 void printList(NodeTree node) {
     while (node != null) {
         System.out.print(node.data + " ");
         node = node.right;
     }
 }

 /* Driver program to test above functions*/
 public static void main(String[] args) {

     BinaryTreeToDll tree = new BinaryTreeToDll();

     // Let us create the tree shown in above diagram
     tree.root = new NodeTree(10);
     tree.root.left = new NodeTree(12);
     tree.root.right = new NodeTree(15);
     tree.root.left.left = new NodeTree(25);
     tree.root.left.right = new NodeTree(30);
     tree.root.right.left = new NodeTree(36);

     // Convert to DLL
     NodeTree head = tree.bintree2list(root);

     // Print the converted list
     tree.printList(head);
 }
}