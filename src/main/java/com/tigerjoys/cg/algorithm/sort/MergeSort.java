package com.tigerjoys.cg.algorithm.sort;

// 归并排序
public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{4, 7, 2, 5, 8, 1, 9, 3};
        mergeSort(a, 0, a.length - 1);
        ArrayUtils.print(a);
    }

    private static void mergeSort(int[] a, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;
            mergeSort(a, startIndex, mid); // 左边归并
            mergeSort(a, mid + 1, endIndex); // 右边归并
            merge(a, startIndex, mid, endIndex); // 合并两个序列
        }
    }

    private static void merge(int[] a, int startIndex, int mid, int endIndex) {
        int[] temp = new int[endIndex - startIndex + 1];
        int i = startIndex;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= endIndex) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 左边剩余的填充
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 右边剩余的填充
        while (j <= endIndex) {
            temp[k++] = a[j++];
        }

        // 将temp元素全部拷贝到原来的数组中
        if (temp.length >= 0) {
            System.arraycopy(temp, 0, a, startIndex, temp.length);
        }
    }

}
