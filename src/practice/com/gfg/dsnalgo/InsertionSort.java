package practice.com.gfg.dsnalgo;

public class InsertionSort {
	public void insertionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (less(arr[j], arr[j - 1]))
					exchange(arr, j, j-1);
			}
		}
	}

	private void exchange(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private boolean less(int i, int j) {
		// TODO Auto-generated method stub
		return i < j;
	}

	public static void main(String[] args) {
		int arr[] = { 6, 5, 3, 2, 1, 9 };
		InsertionSort sort = new InsertionSort();
		sort.insertionSort(arr);
		for(int num:arr){
			System.out.print(" "+num);
		}
	}
}
