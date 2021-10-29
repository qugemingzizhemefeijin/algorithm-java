package com.tigerjoys.cg.algorithm.sort;

import com.tigerjoys.cg.algorithm.utils.Tools;

import java.util.Arrays;

public class TopK问题 {

    public static void main(String[] args) {
        Tools.printIntArray(topk2(new int[]{9,2,3,5,6,4,1,7}, 3));
    }

    // 其实只需要局部排序即可，冒泡排序，只需要排序出最大的n个就行了。
    public static int[] topk2(int[] arr, int n) {
        bubbleSort(arr, n);
        return Arrays.copyOf(arr, n);
    }

    // 冒泡排序
    private static void bubbleSort(int[] arr, int n) {
        for(int i=0;i<arr.length && i < n;i++) {
            boolean flag = true;
            for(int j=arr.length-1;j>i;j--) {
                if(arr[j - 1] < arr[j]) {
                    ArrayUtils.swap(arr, j - 1, j);
                    flag = false;
                }
            }
            if(flag) {
                break;
            }
        }
    }

    // 先排序，最后求出，效率差，需要将所有的值都排序。
    public static int[] topk1(int[] arr, int n) {
        // 先排序，再拷贝
        insertionSort(arr);
        return Arrays.copyOf(arr, n);
    }

    private static void insertionSort(int[] arr) {
        for(int i=1;i<arr.length;i++) {
            int v = arr[i];
            int selectIndex = i - 1;

            while(selectIndex >= 0 && arr[selectIndex] < v) {
                // 交换
                arr[selectIndex + 1] = arr[selectIndex + 1] + arr[selectIndex];
                arr[selectIndex] = arr[selectIndex + 1] - arr[selectIndex];
                arr[selectIndex + 1] = arr[selectIndex + 1] - arr[selectIndex];
                selectIndex--;
            }
        }
    }

}
