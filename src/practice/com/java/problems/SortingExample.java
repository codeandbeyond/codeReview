package practice.com.java.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingExample {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		Student s1 = new Student("Amit", "Jain", 123, 25);
		Student s2 = new Student("Ashis", "Jain", 125, 50);
		Student s3 = new Student("Ashis", "Abhishek", 025, 12);
		Student s4 = new Student("Bijay", "Avasti", 31, 30);
		Student s5 = new Student("Lisha", "Mishra", 12, 31);
		Student s6 = new Student("Shveta", "Panda", 123, 36);
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		list.add(s6);
		Collections.sort(list);
		System.out.println(list);
		Collections.sort(list, new NameComparator());
		System.out.println(list);
	}
}
