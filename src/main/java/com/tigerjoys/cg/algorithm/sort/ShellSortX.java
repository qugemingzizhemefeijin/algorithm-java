package com.tigerjoys.cg.algorithm.sort;

/**
 * 希尔排序
 * 增量一般取logn(n)会比较好，看书上说的。。不过有一些人也直接/2取increment
 * 相当于一个增强版的插入排序，只是跳着将大的数字往后移动，
 * 最后一轮increment为1的时候，就是插入排序。
 *
 * @author chengang
 * @create 2018-04-15 15:06
 */
public class ShellSortX {

    public static void main(String[] args) {
        int increment = ArrayUtils.SQLIST.length;
        int d = (int)(Math.log(ArrayUtils.SQLIST.length) / Math.log(2));
        do {
            increment = increment / d + 1;
            for(int i=increment;i<ArrayUtils.SQLIST.length;i++) {
                if(ArrayUtils.SQLIST[i] < ArrayUtils.SQLIST[i - increment]) {
                    for(int j=i-increment;j>=0 && ArrayUtils.SQLIST[j] > ArrayUtils.SQLIST[j+increment];j-=increment) {
                        ArrayUtils.cryleCounter();
                        ArrayUtils.swap(j , j+increment);
                    }
                }
            }
        } while(increment > 1);

        ArrayUtils.print();
    }

}
