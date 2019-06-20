package com.tigerjoys.cg.algorithm.sort;

/**
 * 小根堆排序
 *
 * @author chengang
 * @create 2018-04-16 8:05
 */
public class MinHeapSort {

    public static void main(String[] args) {
        ArrayUtils.print();
        int i;
        for(i=ArrayUtils.SQLIST.length/2-1;i>=0;i--) {
            ArrayUtils.cryleCounter();
            heapAdjust(i,ArrayUtils.SQLIST.length-1);
        }
        for(i=ArrayUtils.SQLIST.length-1;i>=0;i--) {
            ArrayUtils.cryleCounter();
            ArrayUtils.swap(0 , i);
            heapAdjust(0 , i-1);
        }

        ArrayUtils.print();
    }

    public static void heapAdjust(int s , int m) {
        int temp = ArrayUtils.SQLIST[s];
        for(int i=s*2+1;i<=m;i*=2) {
            if(i < m && ArrayUtils.SQLIST[i] > ArrayUtils.SQLIST[i+1]) {
                i++;
            }

            if(temp <= ArrayUtils.SQLIST[i]) {
                break;
            }

            ArrayUtils.SQLIST[s] = ArrayUtils.SQLIST[i];
            s = i;
        }
        ArrayUtils.SQLIST[s] = temp;
        System.out.println("============");
        ArrayUtils.print();
    }

}
