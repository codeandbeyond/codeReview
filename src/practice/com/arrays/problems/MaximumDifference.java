package practice.com.arrays.problems;

public class MaximumDifference {

	public static int getMaxDiffBetweenTwoIndex(int a[]) {
		int max_So_Far = 0;
		int minSo_Far = Integer.MAX_VALUE;
		int max_Index = -1;
		int min_Index = -1;
		for (int i = 0, j = a.length - 1; i <= j; i++, j--) {
			if (max_So_Far < a[j]) {
				max_So_Far = a[j];
				max_Index = j;
				if (max_So_Far > minSo_Far) {
					return max_Index - min_Index;
				}
			}
			if (minSo_Far > a[i]) {
				min_Index = i;
				minSo_Far = a[i];
				if (max_So_Far > minSo_Far) {
					return max_Index - min_Index;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] input={34, 8, 10, 3, 2, 80, 30, 33, 1};
		System.out.println(" Difference "+getMaxDiffBetweenTwoIndex(input));
	}
}
