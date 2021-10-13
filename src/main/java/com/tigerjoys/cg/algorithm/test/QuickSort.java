package com.tigerjoys.cg.algorithm.test;

import com.tigerjoys.cg.algorithm.sort.ArrayUtils;

public class QuickSort {

	public static void main(String[] args) {
		//quickSort1(0, ArrayUtils.length()-1);
		quickSort2(0, ArrayUtils.length()-1);
		ArrayUtils.print();
	}
	
	//快速排序（双边循环）
	protected static void quickSort2(int startIndex, int endIndex) {
		if(startIndex >= endIndex) {
			return;
		}
		//得到基准元素位置
		int prvotIndex = partition2(startIndex, endIndex);
		//根据基准元素，分成两部分进行递归排序
		quickSort2(startIndex, prvotIndex - 1);
		quickSort2(prvotIndex + 1, endIndex);
	}
	
	private static int partition2(int startIndex, int endIndex) {
		int pivot = ArrayUtils.get(startIndex);
		int left = startIndex, right = endIndex;
		while(left != right) {
			//控制右侧指针左移
			while(left < right && ArrayUtils.get(right) > pivot) {
				right--;
				ArrayUtils.cryleCounter();
			}
			//控制左侧指针右移(注意此处的<=，不然就卡死了)
			while(left < right && ArrayUtils.get(left) <= pivot) {
				left++;
				ArrayUtils.cryleCounter();
			}
			if(left < right) {
				ArrayUtils.swap(left, right);
			}
			ArrayUtils.cryleCounter();
		}
		
		//最后pivot和指针重合点进行交换
		if(startIndex != left) {
			ArrayUtils.set(startIndex, ArrayUtils.get(left));
			ArrayUtils.set(left, pivot);
			ArrayUtils.swapCounter();
		}
		return left;
	}
	
	//快速排序（单边循环）
	//就是先获取一个值，将小的放到此值前面，大的放到此值后面，最后此值放中间。
	protected static void quickSort1(int startIndex, int endIndex) {
		if(startIndex >= endIndex) {
			return;
		}
		//得到基准元素位置
		int prvotIndex = partition1(startIndex, endIndex);
		//根据基准元素，分成两部分进行递归排序
		quickSort1(startIndex, prvotIndex - 1);
		quickSort1(prvotIndex + 1, endIndex);
	}
	
	private static int partition1(int startIndex, int endIndex) {
		// 取第一个位置（也可以选择随机位置）的元素作为基准元素
		int pivot = ArrayUtils.get(startIndex);
		int mark = startIndex;
		//此处循环startIndex - endIndex，将小的值放到mark的左边，大的值放到mark的右边
		for(int i=startIndex+1;i<=endIndex;i++) {
			if(ArrayUtils.get(i) < pivot) {
				mark++;
				if(i != mark) {
					ArrayUtils.swap(i, mark);
				}
			}
			ArrayUtils.cryleCounter();
		}
		
		if(mark != startIndex) {
			ArrayUtils.swap(mark, startIndex);
		}
		return mark;
	}

}
