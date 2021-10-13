package com.tigerjoys.cg.algorithm.test;

import com.tigerjoys.cg.algorithm.sort.ArrayUtils;

//选择排序
public class SelectionSort {
	
	public static void selectSort() {
		for(int i=0;i<ArrayUtils.length()-1;i++) {
			int min = ArrayUtils.get(i);
			int minIndex = i;
			for(int j=i+1;j<ArrayUtils.length();j++) {
				if(min > ArrayUtils.get(j)) {
					min = ArrayUtils.get(j);
					minIndex = j;
				}
			}
			
			if(minIndex != i) {
				ArrayUtils.swap(i, minIndex);
			}
		}
	}

	public static void main(String[] args) {
		selectSort();
		ArrayUtils.print();
	}

}
