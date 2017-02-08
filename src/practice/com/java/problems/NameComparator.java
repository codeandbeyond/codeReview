package practice.com.java.problems;

import java.util.Comparator;

public class NameComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		int cmp = s1.getlName().compareTo(s2.getlName());
		if (cmp > 0)
			return 1;
		else if (cmp < 0)
			return -1;
		else {
			return s1.getfName().compareTo(s2.getfName());
		}

	}

}
