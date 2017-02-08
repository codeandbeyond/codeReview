package com.hackthespoj.problems;

import java.math.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

class TestingTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<BigInteger> list = new ArrayList<BigInteger>();
		int t;
		t = Integer.parseInt(br.readLine());
		BigInteger p;
		while (t > 0) {
			int n;
			n = Integer.parseInt(br.readLine());
			p = new BigInteger("1");
			for (int i = 2; i <= n; i++)
				p = p.multiply(new BigInteger("" + i));
			list.add(p);
			t--;
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println("" + list.get(i));
		}
	}
}