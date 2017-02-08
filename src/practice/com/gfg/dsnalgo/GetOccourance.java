package practice.com.gfg.dsnalgo;

public class GetOccourance {
	private int getFirstOccurance(int[] arr, int lo, int hi, int x) {
		if (hi >= lo) {

			int mid = lo + (hi - lo) / 2;
			if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x) {
				return mid;
			} else if (x > arr[mid])
				return getFirstOccurance(arr, mid + 1, hi, x);
			else
				return getFirstOccurance(arr, lo, mid - 1, x);
		}
		return -1;

	}

	private int getLastOccurance(int[] arr, int lo, int hi, int x) {
		if (hi >= lo) {

			int mid = lo + (hi - lo) / 2;
			if ((mid == arr.length - 1 || x < arr[mid + 1]) && arr[mid] == x) {
				return mid;
			} else if (x < arr[mid])
				return getLastOccurance(arr, lo, mid - 1, x);

			else
				return getLastOccurance(arr, mid + 1, hi, x);

		}
		return -1;
	}

	public int getCount(int arr[], int x) {
		int lo = 0;
		int hi = arr.length - 1;
		int first = getFirstOccurance(arr, lo, hi, x);
		int last = getLastOccurance(arr, lo, hi, x);
		int count = (first==-1)&&(last==-1)?0:last - first + 1;
		return count;
	}

	public static void main(String[] args) {
		GetOccourance occourance = new GetOccourance();
		int arr[] = { 1, 2, 2, 3, 3, 3, 3, 3 };
		System.out.println(" Get the occurance of Number 4 in the list " + occourance.getCount(arr, 4));
	}
}
