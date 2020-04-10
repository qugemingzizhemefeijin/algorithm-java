package com.tigerjoys.cg.algorithm.sort;

import java.util.Arrays;

/**
 * 计数统计优化，
 * 比如90-95之间的排序，不需要使用95长度的数组，只需要0-5个即可。。
 * 第二个是非数值类型，值相同的数据存储到计数数组中的时候，分不清到底是谁。
 * 可以将计数数组的值改成是前面数组的值的合，然后，找到一个，此值-1。则可以变成一种稳定排序并且分出相同值的先后顺序值。
 *
 */
public class CountSort2 {
	
	public static void main(String[] args) {
		int[] array = new int[] {1,6,3,7,2,9,4,8,5};
		System.out.println(Arrays.toString(sort(array)));
	}
	
	private static int[] sort(int[] array) {
		//1.得到最大值和最小值
		int min = array[0], max = array[0];
		for(int i=1;i<array.length;i++) {
			if(array[i] > max) {
				max = array[i];
			} else if(array[i] < min) {
				min = array[i];
			}
		}
		//2. 获得值的差距，并创建d+1长度的计数数组
		int d = max - min;
		int[] a = new int[d+1];
		for(int i=0;i<array.length;i++) {
			a[array[i] - min]++;
		}
		//3. 统计数组做变形，后面的元素等于前面的元素之和
		for(int i=1;i<a.length;i++) {
			a[i] += a[i-1];
		}
		//4. 倒序遍历原始数组，从统计数组找到正确位置，输出到结果数组中
		int[] newArray = new int[array.length];
		for(int i=array.length-1;i>=0;i--) {
			newArray[a[array[i]-min]-1] = array[i];
			a[array[i]-min]--;
		}
		
		return newArray;
	}

}
