package com.tigerjoys.cg.algorithm.sort;

/**
 * 小顶堆排序，其实就是二叉堆（最小堆）不断的移除顶部的元素，移除到最后就排好序了。排序完后则是倒序排列
 *
 */
public class HeapMaxSort {
	
	public static void main(String[] args) {
		sort();
		ArrayUtils.print();
	}
	
	private static void sort() {
		//构建小顶堆
		buildMinHeap();
		//逐步删除顶部元素并交换到最后
		for(int i=ArrayUtils.SQLIST.length-1;i>=0;i--) {
			ArrayUtils.swap(i, 0);
			downAdjust(0, i);
		}
	}
	
	private static void buildMinHeap() {
		for(int i=(ArrayUtils.SQLIST.length-2)/2;i>=0;i--) {
			downAdjust(i, ArrayUtils.SQLIST.length);
		}
	}
	
	private static void downAdjust(int parentIndex, int length) {
		int temp = ArrayUtils.SQLIST[parentIndex];
		int childIndex = parentIndex * 2 +1;
		while(childIndex < length) {
			if(childIndex + 1 < length && ArrayUtils.SQLIST[childIndex] > ArrayUtils.SQLIST[childIndex+1]) {
				childIndex++;
			}
			if(temp <= ArrayUtils.SQLIST[childIndex]) {
				break;
			}
			ArrayUtils.SQLIST[parentIndex] = ArrayUtils.SQLIST[childIndex];
			parentIndex = childIndex;
			childIndex = parentIndex * 2 + 1;
		}
		ArrayUtils.SQLIST[parentIndex] = temp;
	}

}
