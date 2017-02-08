package practice.com.arrays.problems;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class NumberOFDistinctSubstring {
	public static int numberdss(String str) {
		HashSet<String> all = new HashSet<>();
		HashSet<StringBuilder> last = new HashSet<>();

		for (int i = 0; i < str.length(); i++) {
			for (StringBuilder sb : last) {
				sb.append(str.charAt(i));
				if (!all.contains(sb.toString())) {
					all.add(sb.toString());
				}
			}
			if (!all.contains(str.charAt(i) + "")) {
				all.add(str.charAt(i) + "");
			}
			last.add(new StringBuilder(str.charAt(i) + ""));
		}
		return all.size();
	}
	public static int number(String str) {
		HashSet<String> all = new HashSet<>();
		
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j <= i; j++) {
				if (!all.contains(str.substring(j, i + 1))) {
					all.add(str.substring(j, i + 1));
				}
			}
		}
		return all.size();
	}
	public static void main(String[] args) {
		
		String str="abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz1234567890";
		try{
			solve(str);
		}catch(IOException ex){
			System.out.println("Caught");
		}
		System.out.println(""+numberdss(str));
	System.out.println(""+number(str));
	
	}
	public static   void solve(String st) throws IOException{
		
	        // Declared as final due the their usage in building a comparator
	        final char[] str =st.toCharArray();
	        final int n = str.length;

	        // Construct suffix array
	        // suffixArray[i] represents str.substring(suffixArray[i], n)
	        Integer[] suffixArray = new Integer[n]; // Integer instead of int for using Arrays.sort()
	        for (int i = 0; i < n; i++)
	            suffixArray[i] = i;

	        // Sort the suffix array by the suffixes
	        Arrays.sort(suffixArray, new Comparator<Integer>() {
	            @Override
	            public int compare(Integer o1, Integer o2) {
	                int i = o1, j = o2;
	                for(; i < n && j < n; i++, j++) {
	                    if (str[i] != str[j]){
	                    	System.out.println(str[i] - str[j]);
	                        return str[i] - str[j];
	                }
	                    }
	                return j-i;
	            }
	        });

	        // Find the length of the longest common prefix for consecutive suffixes
	        int[] lcp = calculateLCP(str, suffixArray);

	        // The number of distinct substrings is the sum of the difference between the length of
	        // each suffix and its corresponding lcp with previous suffix. This is because all
	        // substrings that are prefixes of the lcp have been counted.
	        int sum = 0;
	        for (int i = 0; i < n; i++)
	            sum += (n-suffixArray[i]) - lcp[i];

	        System.out.println(sum);
	    }

	    /**
	     * Calculate the length of longest common prefix for consecutive suffixes
	     *
	     * @return an array containing the lengths of longest common prefix for the given suffix array.
	     */
	    private static int[] calculateLCP(char[] str, Integer[] suffixArray) {
	        int n = str.length;
	        int[] lcp = new int[n];

	        for (int i = 1; i < n; i++) {
	            // Calculate the length of the longest common prefix between (i-1)-th and i-th suffixes
	            int index1 = suffixArray[i-1], index2 = suffixArray[i];
	            while (index1 < n && index2 < n && str[index1++] == str[index2++])
	                lcp[i]++;
	        }

	        return lcp;
	    }
}
