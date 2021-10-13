package com.tigerjoys.cg.algorithm.test;

import com.tigerjoys.cg.algorithm.sort.ArrayUtils;

//插入排序
public class InsertionSort {

	public static void insertSort() {
		for(int i=1;i<ArrayUtils.SQLIST.length;i++) {
			int v = ArrayUtils.SQLIST[i];
			int insertIndex = i - 1;
			
			while(insertIndex >= 0 && ArrayUtils.SQLIST[insertIndex] > v) {
				ArrayUtils.swap(insertIndex + 1, insertIndex);
				insertIndex--;
			}
			
			if(insertIndex + 1 != i) {
				ArrayUtils.SQLIST[insertIndex + 1] = v;
			}
		}
	}

	public static void main(String[] args) {
		insertSort();
		ArrayUtils.print();
	}

}
