package com.tigerjoys.cg.algorithm.sort;

/**
 * 冒泡排序，优化
 * @author chengang
 *
 */
public class BubbleSort4 {
	
	public static void main(String[] args) {
		for(int i=0;i<ArrayUtils.SQLIST.length-1;i++) {
			boolean flag = true;
			for(int j=0;j<ArrayUtils.SQLIST.length-i-1;j++) {
				if(ArrayUtils.SQLIST[j] > ArrayUtils.SQLIST[j+1]) {
					ArrayUtils.cryleCounter();
					ArrayUtils.swap(j, j+1);
					flag = false;
				}
			}
			if(flag) {
				break;
			}
		}
		
		ArrayUtils.print();
	}

}
