package com.tigerjoys.cg.algorithm.test;

import com.tigerjoys.cg.algorithm.sort.ArrayUtils;

public class BubboSort {
	
	//冒泡排序（将小的值不断的交换到最前面）
	protected static final void bubbleSort1() {
		for(int i=0;i<ArrayUtils.length()-1;i++) {
			for(int j=ArrayUtils.length()-1;j>i;j--) {
				if(ArrayUtils.gt(i, j)) {
					ArrayUtils.swap(i, j);
				}
				ArrayUtils.cryleCounter();
			}
			ArrayUtils.cryleCounter();
		}
		ArrayUtils.print();
	}
	
	//冒泡排序（将大的值不断的交换到最后面）
	protected static final void bubbleSort2() {
		for(int i=0;i<ArrayUtils.length()-1;i++) {
			for(int j=0;j<ArrayUtils.length()-i-1;j++) {
				if(ArrayUtils.gt(j, j+1)) {
					ArrayUtils.swap(j, j+1);
				}
				ArrayUtils.cryleCounter();
			}
			ArrayUtils.cryleCounter();
		}
		ArrayUtils.print();
	}
	
	//冒泡排序
	protected static final void bubbleSort3() {
		boolean flag = false;
		for(int i=0;i<ArrayUtils.length()-1;i++) {
			flag = true;
			for(int j=0;j<ArrayUtils.length()-i-1;j++) {
				if(ArrayUtils.gt(j, j+1)) {
					ArrayUtils.swap(j, j+1);
					flag = false;
				}
				ArrayUtils.cryleCounter();
			}
			ArrayUtils.cryleCounter();
			if(flag) {
				break;
			}
		}
		ArrayUtils.print();
	}

	public static void main(String[] args) {
		bubbleSort2();
	}

}
