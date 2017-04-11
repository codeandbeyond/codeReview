package com.hackthespoj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by apatra on 29/03/17.
 */
public class Area {
    public static BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        maxArea();
        long endTime=System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime/1000+" Seconds");
    }

    private static void maxArea() {
        try {
            int numOfElements=Integer.parseInt(reader.readLine());
            String []array=reader.readLine().split(" ");
            try {
                if (numOfElements != array.length) {

                }else{
                    Arrays.sort(array);
                    int maxArea = 0;
                    for (int i = 0; i < array.length; i++) {
                        int arrLength = array.length;
                        int mid = arrLength / 2;
                        if (arrLength % 2 != 0) {
                            maxArea = Integer.parseInt(array[mid]) * (Integer.parseInt(array[arrLength - 1]) - Integer.parseInt(array[mid]));
                        } else {
                            int a = Integer.parseInt(array[mid-1]) * (Integer.parseInt(array[arrLength - 1]) - Integer.parseInt(array[mid-1]));
                            int b = Integer.parseInt(array[mid]) * (Integer.parseInt(array[arrLength - 1]) - Integer.parseInt(array[mid]));
                            int c = Integer.parseInt(array[mid+1]) * (Integer.parseInt(array[arrLength - 1]) - Integer.parseInt(array[mid+1]));
                            maxArea = Math.max(a, b);
                            maxArea = Math.max(maxArea, c);

                        }

                    }
                    System.out.println("Max Area::" + maxArea);
                }
            }catch(Exception e){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
