package com.tigerjoys.cg.algorithm.interview.moka;

import com.tigerjoys.cg.algorithm.sort.ArrayUtils;

public class SelectionSort {

    public static void main(String[] args) {
        int[] a = new int[]{4, 1, 7, 3, 8, 2, 5};
        selectSort(a);
        ArrayUtils.print(a);
    }

    private static void selectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1;j<a.length;j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            if (i != min) {
                ArrayUtils.swap(a, min, i);
            }
        }
    }

}
