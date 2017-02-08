package practice.com.java.problems;

public class Student implements Comparable {
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public Student(String fName, String lName, int rollNo, int age) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.rollNo = rollNo;
		this.age = age;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [fName=" + fName + ", lName=" + lName + ", rollNo=" + rollNo + ", age=" + age + "]";
	}

	private String fName;
	private String lName;
	private int rollNo;
	private int age;

	
	


	
	public int getRollNo() {
		return rollNo;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
