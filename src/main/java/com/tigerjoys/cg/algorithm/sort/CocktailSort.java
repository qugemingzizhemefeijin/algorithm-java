package com.tigerjoys.cg.algorithm.sort;

/**
 * 鸡尾酒排序
 * 
 * 排序过程就像钟摆一样， 第1轮从左到右， 第2轮从右到左， 第3轮再从左到右
 * |1|2|3|4|5|6|7|8|9|
 * |1#2|3|4|5|6|7|8#9|
 * |1#2#3|4|5|6|7#8#9|
 *
 */
public class CocktailSort {
	
	public static void main(String[] args) {
		for(int i=0;i<ArrayUtils.SQLIST.length/2;i++) {
			//有序标记，每一轮的初始值都是true
			boolean isSorted = true;
			//奇数轮，从左向右比较和交换
			for(int j=i;j<ArrayUtils.SQLIST.length-i-1;j++) {
				if(ArrayUtils.SQLIST[j] > ArrayUtils.SQLIST[j+1]) {
					ArrayUtils.cryleCounter();
					ArrayUtils.swap(j, j+1);
					// 有元素交换，所以不是有序的，标记为false
					isSorted = false;
				}
			}
			if(isSorted) {
				break;
			}
			//偶数轮，从右向左比较和交换
			for(int j=ArrayUtils.SQLIST.length-i-1;j>i;j--) {
				if(ArrayUtils.SQLIST[j] < ArrayUtils.SQLIST[j-1]) {
					ArrayUtils.cryleCounter();
					ArrayUtils.swap(j, j-1);
					// 有元素交换，所以不是有序的，标记为false
					isSorted = false;
				}
			}
			if(isSorted) {
				break;
			}
		}
		ArrayUtils.print();
	}

}
