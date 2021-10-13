package com.tigerjoys.cg.algorithm.sort;

/**
 * 插入排序
 * 以一个分隔索引来区分已排序的部分和未排序的部分，然后将未排序的部分放入到排序部分合适的位置，直到最后都排完。
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		for(int i=1;i<ArrayUtils.SQLIST.length;i++) {
			int v = ArrayUtils.SQLIST[i];
			int insertIndex = i - 1;
			//从大到小排序，如果当前指定的位置比比较的值要小，则需要将数据后移
			while(insertIndex >= 0 && ArrayUtils.SQLIST[insertIndex] > v) {
				ArrayUtils.swap(insertIndex + 1, insertIndex);
				insertIndex--;
			}
			//如果insertIndex变动过，则交换
			if(insertIndex+1 != i) {
				ArrayUtils.SQLIST[insertIndex + 1] = v;
			}
		}
		ArrayUtils.print();
	}

}
