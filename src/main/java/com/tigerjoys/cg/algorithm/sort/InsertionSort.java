package com.tigerjoys.cg.algorithm.sort;

/**
 * 插入排序
 * 就是将数据插入到已经排序好的序列中
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		for(int i=1;i<ArrayUtils.SQLIST.length;i++) {
			if(ArrayUtils.SQLIST[i] < ArrayUtils.SQLIST[i-1]) {
				int temp = ArrayUtils.SQLIST[i];
				//这段代码的意思是依次向后迭代，将temp数据插入到位置上
				for(int j=i-1;j>=0 && ArrayUtils.SQLIST[j] > temp;j--) {
					ArrayUtils.swap(j, j+1);
				}
			}
		}
		ArrayUtils.print();
	}

}
