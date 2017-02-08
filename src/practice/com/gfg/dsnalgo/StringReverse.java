package practice.com.gfg.dsnalgo;

public class StringReverse {
	public String reverseStringRecursio(String string) {
		if (string.length() < 2)
			return string;
		return string.charAt(string.length() - 1) + reverseStringRecursio(string.substring(0, string.length() - 1));

	}

	public static void main(String[] args) {
		StringReverse strverse = new StringReverse();
		String input = "Ashok";
		System.out.println("Reverse of " + input + " is " + strverse.reverseStringRecursio(input));

	}
}
