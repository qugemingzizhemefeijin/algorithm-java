package com.tigerjoys.cg.algorithm.sort;

/**
 * 冒泡算法3
 *
 * @author chengang
 * @create 2018-04-13 16:15
 */
public class BubbleSort3 {

    public static void main(String[] args) {
        boolean flag = true;
        for(int i=0;i<ArrayUtils.SQLIST.length-1 && flag;i++) {
            flag = false;
            ArrayUtils.cryleCounter();
            for(int j=ArrayUtils.SQLIST.length-1;j>i;j--) {
                if(ArrayUtils.SQLIST[j-1] > ArrayUtils.SQLIST[j]) {
                    ArrayUtils.swap(j-1,j);
                    flag = true;
                }
            }
        }

        ArrayUtils.print();
    }

}
