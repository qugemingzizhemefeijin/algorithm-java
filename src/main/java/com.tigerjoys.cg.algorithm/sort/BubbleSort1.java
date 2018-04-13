package com.tigerjoys.cg.algorithm.sort;

/**
 * 冒泡算法1
 *
 * @author chengang
 * @create 2018-04-13 15:36
 */
public class BubbleSort1 {

    public static void main(String[] args) {
        for(int i=0;i<ArrayUtils.SQLIST.length-1;i++) {
            for(int j=i+1;j<ArrayUtils.SQLIST.length;j++) {
                ArrayUtils.cryleCounter();
                if(ArrayUtils.SQLIST[i] > ArrayUtils.SQLIST[j]) {
                    ArrayUtils.swap(i,j);
                }
            }
        }
        ArrayUtils.print();
    }

}
