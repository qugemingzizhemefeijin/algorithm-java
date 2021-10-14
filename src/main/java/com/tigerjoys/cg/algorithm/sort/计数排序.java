package com.tigerjoys.cg.algorithm.sort;

// 通过构造一个n-m的数据，来进行计数最后复原排序数组
public class 计数排序 {

    public static void main(String[] args) {
        int[] arr = counter_sort();
        ArrayUtils.print(arr);
    }

    private static int[] counter_sort() {
        int min = Integer.MAX_VALUE, max = 0;
        for(int v : ArrayUtils.SQLIST) {
            min = Math.min(v, min);
            max = Math.max(v, max);
        }
        int[] t = new int[max - min + 1];
        for(int v : ArrayUtils.SQLIST) {
            t[v - min]++;
        }

        int idx = 0;
        int[] arr = new int[ArrayUtils.SQLIST.length];
        for(int i=0;i<t.length;i++) {
            if(t[i] >= 1) {
                for(int x = 0;x<t[i];x++) {
                    arr[idx++] = i;
                }
            }
        }
        return arr;
    }

}
