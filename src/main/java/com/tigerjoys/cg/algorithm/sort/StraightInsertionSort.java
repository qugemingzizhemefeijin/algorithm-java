package com.tigerjoys.cg.algorithm.sort;

/**
 * 直接插入排序
 *
 * @author chengang
 * @create 2018-04-13 17:39
 */
public class StraightInsertionSort {

    public static void main(String[] args) {
        for(int i=1;i<ArrayUtils.SQLIST.length;i++) {
            if(ArrayUtils.SQLIST[i] < ArrayUtils.SQLIST[i-1]) {
                int temp = ArrayUtils.SQLIST[i];
                int j = i-1;
                for(;j>=0 && ArrayUtils.SQLIST[j] > temp;j--) {
                    ArrayUtils.cryleCounter();
                    ArrayUtils.swap(j+1 , j);
                }
                //ArrayUtils.SQLIST[j+1] = temp;
            }
        }

        ArrayUtils.print();
    }

}
