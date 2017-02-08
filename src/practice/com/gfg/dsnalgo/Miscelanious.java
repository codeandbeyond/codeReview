package practice.com.gfg.dsnalgo;

public class Miscelanious {
	static void printRepeating(int arr[], int size) {
		int i;

		for (i = 0; i < size; i++) {
			if (arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.println(Math.abs(arr[i]));
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 1, 3, 6, 6 };

		printRepeating(arr, arr.length);
	}
}
