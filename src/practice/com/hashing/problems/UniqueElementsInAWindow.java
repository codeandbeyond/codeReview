package practice.com.hashing.problems;

import java.util.HashSet;
import java.util.Set;

public class UniqueElementsInAWindow {
	
	public static void main(String[] args) {
		int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
		int k = 1;
		Set s = new HashSet();

		for (int i = 0; i < arr.length - (k - 1); i++) {
			for (int j = i; j < k + i; j++) {
				s.add(arr[j]);
			}
			System.out.print(" Size is " + s.size() + " Unique Elements are " + s);
			System.out.println("Removing " + i);
			s.remove(arr[i]);
			System.out.println(" ");
		}
	}
	
}
