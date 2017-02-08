package practice.com.gfg.dsnalgo;

public class ConvertArrays {
	public int convertZeros(int[] target, int n) {
		int i;
		int result = 0;
		int zeroCount = 0;
		while (true) {
			for (i = 0; i < n; i++) {
				if (target[i] % 2 != 0)
					break;
				if (target[i] == 0)
					zeroCount++;
			}
			if (zeroCount == n) {
				return result;
			}
			if (i == n) {
				for (int j = 0; j < target.length; j++) {
					target[j] = target[j] / 2;

				}
				result++;
			}
			for (int j = i; j < n; j++) {
				if (target[j] % 2 != 0) {
					target[j] = target[j] - 1;
					result++;
				}
			}

		}
	}

	public static void main(String[] args) {
		int arr[] = { 2, 5 };
		ConvertArrays ca = new ConvertArrays();
		System.out.println(ca.convertZeros(arr, arr.length));
	}
}
