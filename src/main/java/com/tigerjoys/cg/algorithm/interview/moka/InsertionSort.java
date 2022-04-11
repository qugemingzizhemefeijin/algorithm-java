package com.tigerjoys.cg.algorithm.interview.moka;

import com.tigerjoys.cg.algorithm.sort.ArrayUtils;

public class InsertionSort {

    // 插入排序
    public static void main(String[] args) {
        int[] a = new int[]{4, 1, 7, 3, 8, 2, 5};
        insertSort(a);
        ArrayUtils.print(a);
    }

    private static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int v = a[i];
            int inertIndex = i - 1;
            while(inertIndex >= 0 && a[inertIndex] > v) {
                ArrayUtils.swap(a, inertIndex, inertIndex + 1);
                inertIndex--;
            }
        }
    }

}
