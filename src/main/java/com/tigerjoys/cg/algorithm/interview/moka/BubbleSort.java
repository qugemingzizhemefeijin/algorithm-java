package com.tigerjoys.cg.algorithm.interview.moka;

import com.tigerjoys.cg.algorithm.sort.ArrayUtils;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = new int[]{4, 7, 2, 5, 8, 1, 9, 3};
        bubble1(a);
        ArrayUtils.print(a);
    }

    private static void bubble1(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    ArrayUtils.swap(a, i, j);
                }
            }
        }
    }

}
