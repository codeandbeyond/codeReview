package practice.com.gfg.dsnalgo;

public class RearrangeInMaxMin {
	public void rearrange(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			while (temp > 0) {
				int j = (i < (arr.length) / 2) ? 2 * i + 1 : 2 * (arr.length - 1 - i);
				if (i == j) {
					arr[i] = -temp;
					break;
				}
				swap(arr, j, temp);
				arr[j] = -arr[j];
				i = j;
			}
		}
	}

	private void swap(int[] arr, int j, int temp) {
		int x = arr[j];
		arr[j] = temp;
		temp = x;

	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		RearrangeInMaxMin rma = new RearrangeInMaxMin();
		rma.rearrange(arr);
		for (int i : arr) {
			System.out.println(" " + i);
		}
	}
}
