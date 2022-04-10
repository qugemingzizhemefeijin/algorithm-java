package com.tigerjoys.cg.algorithm.interview.moka;

import com.tigerjoys.cg.algorithm.sort.ArrayUtils;

public class QuickSort {

    public static void quickSort(int[] a, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int markIndex = partition(a, startIndex, endIndex);
        quickSort(a, 0, markIndex - 1);
        quickSort(a, markIndex + 1, endIndex);
    }

    private static int partition(int[] a, int startIndex, int endIndex) {
        int pov = a[startIndex];
        int mark = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (a[i] < pov) {
                mark++;
                ArrayUtils.swap(a, i, mark);
            }
        }

        ArrayUtils.swap(a, mark, startIndex);
        return mark;
    }

    public static void main(String[] args) {
        int[] a = {23, 10, 12, 56, 34, 85, 47, 37, 9, 6, 2};
        quickSort(a, 0, a.length - 1);
        ArrayUtils.print(a);
    }
}
