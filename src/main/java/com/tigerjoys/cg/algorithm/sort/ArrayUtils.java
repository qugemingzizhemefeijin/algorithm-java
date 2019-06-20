package com.tigerjoys.cg.algorithm.sort;

/**
 * 数组工具类
 *
 * @author chengang
 * @create 2018-04-13 15:33
 */
public class ArrayUtils {

    public static final int[] SQLIST = {9,1,5,8,3,7,4,6};

    //交换计数
    private static int SAWP_COUNTER = 0;

    //循环计数
    private static int CRILY_COUNTER = 0;

    /**
     * 交换数组指定位置的元素
     * @param i - 位置1
     * @param j - 位置2
     */
    public static final void swap(int i , int j) {
        int temp = SQLIST[i];
        SQLIST[i] = SQLIST[j];
        SQLIST[j] = temp;

        SAWP_COUNTER++;
    }

    /**
     * 循环计数
     */
    public static final void cryleCounter(){
        CRILY_COUNTER++;
    }

    /**
     * 打印数组内容
     */
    public static final void print(){
        for(int i=0;i<SQLIST.length;i++) {
            if(i>0) {
                System.out.print(" , ");
            }
            System.out.print(SQLIST[i]);
        }
        System.out.println();
        System.out.println("总交换次数：" + SAWP_COUNTER);
        System.out.println("总循环次数：" + CRILY_COUNTER);
    }

    private ArrayUtils(){

    }

}
