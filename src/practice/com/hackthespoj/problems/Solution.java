package practice.com.hackthespoj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	// public static int cardDateMap[] = { 1, 2, 4, 8, 6 };

	public static void main(String[] args) {
		boolean count[] = new boolean[10];
		try {
			// Set<Integer> uniqueIds = new HashSet<Integer>();
			// int minModulo = 2;
			String input = reader.readLine();
			if (input != null || input.length() != 0) {
				String[] ids = input.split(" ");
				int poleLength = Integer.parseInt(ids[0]);
				int noofelements = Integer.parseInt(ids[1]);
				List left = new ArrayList();
				List right = new ArrayList();
				int i = 2;
				while (i <=noofelements+1) {
					int curr = Integer.parseInt(ids[i]);
					left.add(minFromLeft(poleLength, curr));
					right.add(maxFromright(poleLength, curr));
					i++;
				}
				int earliest = (int) Collections.max(left);
				int latest = (int) Collections.max(right);
				System.out.println(earliest + " " + latest);
			}
		} catch (Exception e) {
			System.out.println("Input Should be valid");
			e.printStackTrace();
		}
	}

	static int minFromLeft(int poleLength, int curr) {
		int fromLeft = curr - 0;
		int fromRight = poleLength - curr;
		return Math.min(fromLeft, fromRight);
	}

	static int maxFromright(int poleLength, int curr) {
		int fromLeft = curr - 0;
		int fromRight = poleLength - curr;
		return Math.max(fromLeft, fromRight);
	}

}
