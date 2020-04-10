package com.tigerjoys.cg.algorithm.sort;

/**
 * 大顶堆排序，其实就是二叉堆（最大堆）不断的移除顶部的元素，移除到最后就排好序了。排序完后则是正序排列
 *
 */
public class HeapMinSort {
	
	public static void main(String[] args) {
		sort();
		ArrayUtils.print();
	}
	
	private static void sort() {
		//首先构造大顶堆
		buildMaxHead();
		//再逐步将堆顶元素与最后一个元素交换
		for(int i=ArrayUtils.SQLIST.length-1;i>0;i--) {
			ArrayUtils.swap(i, 0);
			//重新构建大顶堆
			downAdjust(0, i);
		}
	}
	
	private static void buildMaxHead() {
		for(int i=(ArrayUtils.SQLIST.length-2)/2;i>=0;i--) {
			downAdjust(i,ArrayUtils.SQLIST.length);
		}
	}
	
	/**
	 * 下沉调整
	 * @param parentIndex - 父节点
	 * @param length - 堆的有效大小
	 */
	private static void downAdjust(int parentIndex, int length) {
		int temp = ArrayUtils.SQLIST[parentIndex];
		int childIndex = parentIndex * 2 + 1;
		while(childIndex < length) {
			//看是否有右孩子，并且右孩子大于左孩子
			if(childIndex + 1 < length && ArrayUtils.SQLIST[childIndex] < ArrayUtils.SQLIST[childIndex+1]) {
				childIndex++;
			}
			//父节点大的话，则不需要继续下沉了
			if(temp >= ArrayUtils.SQLIST[childIndex]) {
				break;
			}
			ArrayUtils.SQLIST[parentIndex] = ArrayUtils.SQLIST[childIndex];
			parentIndex = childIndex;
			childIndex = parentIndex*2+1;
		}
		ArrayUtils.SQLIST[parentIndex] = temp;
	}

}
