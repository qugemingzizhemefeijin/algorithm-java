package com.tigerjoys.cg.algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序
 *
 */
public class CountSort {
	
	public static void main(String[] args) {
		//得到数列的最大值
		int max = ArrayUtils.SQLIST[0];
		for(int i=1;i<ArrayUtils.SQLIST.length;i++) {
			if(max < ArrayUtils.SQLIST[i]) {
				max = ArrayUtils.SQLIST[i];
			}
		}
		
		//创建一个max+1长度的数组
		int[] countArray = new int[max+1];
		//遍历数列，填充统计数组
		for(int i=0;i<ArrayUtils.SQLIST.length;i++) {
			countArray[ArrayUtils.SQLIST[i]]++;
		}
		// 遍历统计数组，输出结果
		int index = 0;
		int[] sortedArray = new int[ArrayUtils.SQLIST.length];
		for(int i=0;i<countArray.length;i++) {
			for(int j=0;j<countArray[i];j++) {
				sortedArray[index++] = i;
			}
		}
		
		System.out.println(Arrays.toString(sortedArray));
	}

}
