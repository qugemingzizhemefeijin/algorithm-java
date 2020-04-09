package com.tigerjoys.cg.algorithm.sort;

/**
 * 有序区的长度和排序的轮数是相等的。第二轮排序区后的有序区长度是2..依此类推
 * @author chengang
 *
 */
public class BubbleSort5 {

	public static void main(String[] args) {
		//记录最后一次交换的位置
		int lastExchangeIndex = 0;
		//无序数列的边界，每次比较只需比到这里即可
		int sortBorder = ArrayUtils.SQLIST.length - 1;
		for(int i=0;i<ArrayUtils.SQLIST.length-1;i++) {
			boolean flag = true;
			for(int j=0;j<sortBorder;j++) {
				if(ArrayUtils.SQLIST[j] > ArrayUtils.SQLIST[j+1]) {
					ArrayUtils.cryleCounter();
					ArrayUtils.swap(j, j+1);
					flag = false;
					// 更新为最后一次交换元素的位置
					lastExchangeIndex = j;
				}
			}
			
			sortBorder = lastExchangeIndex;
			if(flag) {
				break;
			}
		}
		
		ArrayUtils.print();
	}

}
