package com.tigerjoys.cg.algorithm.sort;

/**
 * 简单选择排序
 *
 * 简单选择排序法 (Simp坠 Selection Sort) 就是通过 n - i 次关键字间的比较，
 * 从 n- j + 1 个记录中选出关键字最小的记录，并和第 i ( 1 < i <;n) 个记录交换之。
 *
 * @author chengang
 * @create 2018-04-13 16:44
 */
public class SelectionSort1 {

    public static void main(String[] args) {
        for(int i=0;i<ArrayUtils.SQLIST.length-1;i++) {
            int min = i;
            for(int j=i+1;j<ArrayUtils.SQLIST.length;j++) {
                ArrayUtils.cryleCounter();

                if(ArrayUtils.SQLIST[min] > ArrayUtils.SQLIST[j]) {
                    min = j;
                }
            }

            if(min != i) {
                ArrayUtils.swap(i , min);
            }
        }

        ArrayUtils.print();
    }

}
