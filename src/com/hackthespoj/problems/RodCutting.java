package com.hackthespoj.problems;

import java.util.Arrays;
import java.util.Collections;

public class RodCutting {
    static int p[] = {0, 1, 5, 8, 9, 10};
    static int revenue[] = new int[p.length];
    static int rodLength = 5;

    public static void main(String[] args) {
        System.out.println(" I don't know what i am printing probvably Maximum Revenue " + revenueViaRecursion(p, rodLength));
        maxArea();
    }

    public static int revenueViaRecursion(int p[], int rodLength) {
        int q = 0;
        if (revenue[rodLength] > 0) {
            return revenue[rodLength];
        }
        for (int i = 1; i <= rodLength; i++) {
            q = Math.max(q, p[i] + revenueViaRecursion(p, rodLength - i));
            revenue[rodLength] = q;
        }
        return revenue[rodLength];
    }

    public static int maxArea() {
        int array[] = {1, 5, 4, 3};
        Arrays.sort(array);
        int maxArea = 0;
        for (int i = 0; i < array.length; i++) {
            int arrLength = array.length;
            int mid = arrLength / 2;
            if (arrLength % 2 != 0) {
                maxArea = array[mid] * (array[arrLength - 1] - array[mid]);
            } else {
                int a = array[mid - 1] * (array[arrLength - 1] - array[mid - 1]);
                int b = array[mid] * (array[arrLength - 1] - array[mid]);
                int c = array[mid + 1] * (array[arrLength - 1] - array[mid + 1]);
                maxArea = Math.max(a, b);
                maxArea = Math.max(maxArea, c);

            }

        }
        System.out.println("Max Area::" + maxArea);
        return 0;
    }
}
