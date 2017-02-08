package com.linkedlist.problems;

public class LinkedListImplementaion {
	public static void main(String[] args) {
		LinkedListService service = new LinkedListService();
		System.out.println(service.createNodeIntheBegining(1));
		System.out.println(service.createNodeIntheBegining(2));
		System.out.println(service.createNodeIntheBegining(3));
		System.out.println(service.createNodeIntheBegining(4));
		System.out.println(service.createNodeIntheBegining(5));
		System.out.println(service.createNodeIntheBegining(6));
		System.out.println(service.createNodeIntheBegining(7));
		service.show();
		service.deleteLastNode();
		
		/*service.sort();*/
		/*
		 * System.out.println("Insert In Between " + service.insertAfter(86,
		 * 78));
		 */
		service.show();
		/*System.out.println("Length of Linked List is " + service.findLength());
		System.out.println("Searching 189 " + service.searchElement(265));
		System.out.println("Element in 4 th position from head "
				+ service.getNthNode(4));
		System.out.println("");
		 service.delete(); 
		System.out.println("Middle Node is " + service.getMiddleNode());
		System.out.println("Is ListPalindrome " + service.isPalindrome());
		service.show();*/
	}
}
