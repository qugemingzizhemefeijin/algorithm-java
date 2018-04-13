package com.tigerjoys.cg.algorithm.sort;

/**
 * 冒泡算法2
 *
 * @author chengang
 * @create 2018-04-13 16:01
 */
public class BubbleSort2 {

    public static void main(String[] args) {
        for(int i=0;i<ArrayUtils.SQLIST.length-1;i++) {
            for(int j=ArrayUtils.SQLIST.length-1;j>i;j--) {
                ArrayUtils.cryleCounter();
                if(ArrayUtils.SQLIST[j-1] > ArrayUtils.SQLIST[j]) {
                    ArrayUtils.swap(j-1,j);
                }
            }
        }

        ArrayUtils.print();
    }

}
