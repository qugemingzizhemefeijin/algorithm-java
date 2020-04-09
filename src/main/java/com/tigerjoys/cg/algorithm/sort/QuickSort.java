package com.tigerjoys.cg.algorithm.sort;

/**
 * 单边循环快速排序
 *
 */
public class QuickSort {
	
	public static void quickSort(int startIndex, int endIndex) {
		//递归结束条件：startIndex大于或等于endIndex时
		if(startIndex >= endIndex) {
			return;
		}
		//得到基准元素位置
		int prvotIndex = partition(startIndex, endIndex);
		//根据基准元素，分成两部分进行递归排序
		quickSort(startIndex, prvotIndex - 1);
		quickSort(prvotIndex + 1, endIndex);
	}
	
	/**
	 * 分治（单边循环法）
	 */
	private static int partition(int startIndex, int endIndex) {
		// 取第一个位置（也可以选择随机位置）的元素作为基准元素
		int pivot = ArrayUtils.SQLIST[startIndex];
		int mark = startIndex;
		
		for(int i=startIndex+1;i<=endIndex;i++) {
			if(ArrayUtils.SQLIST[i] < pivot) {
				mark++;
				ArrayUtils.cryleCounter();
				ArrayUtils.swap(i, mark);
			}
		}
		
		ArrayUtils.cryleCounter();
		ArrayUtils.swap(startIndex, mark);
		return mark;
	}
	
	public static void main(String[] args) {
		quickSort(0, ArrayUtils.SQLIST.length-1);
		ArrayUtils.print();
	}

}
