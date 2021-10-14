package com.tigerjoys.cg.algorithm.sort;

// 通过递归，来交换前后的值
public class 臭皮匠排序 {

    public static void main(String[] args) {
        stooge_sort(0, ArrayUtils.length() - 1);
        ArrayUtils.print();
    }

    private static void stooge_sort(int i, int j) {
        if(ArrayUtils.SQLIST[i] > ArrayUtils.SQLIST[j]) {
            ArrayUtils.swap(i, j);
        }
        if(i + 1 >= j) {
            return;// 是否结束
        }

        int k = (j - i + 1) / 3;// 三等分
        stooge_sort(i, j- k); // 前2/3半区
        stooge_sort(i + k, j); // 后2/3半区
        stooge_sort(i, j- k); // 前2/3半区
    }

}
