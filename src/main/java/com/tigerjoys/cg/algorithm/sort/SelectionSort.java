package com.tigerjoys.cg.algorithm.sort;

/**
 * 选择排序，
 * 选择排序就是每次循环的时候选择n-length之间最小的值与n交换
 *
 */
public class SelectionSort {
	
	public static void main(String[] args) {
		for(int i=0;i<ArrayUtils.SQLIST.length-1;i++) {
			int min = i;
			for(int j=i+1;j<ArrayUtils.SQLIST.length;j++) {
				if(ArrayUtils.SQLIST[min] > ArrayUtils.SQLIST[j]) {
					min = j;
				}
			}
			
			if(min != i) {
				ArrayUtils.swap(min, i);
			}
		}
		
		ArrayUtils.print();
	}

}
