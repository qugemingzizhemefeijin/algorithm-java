package com.tigerjoys.cg.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序
 * 桶排序可以支持非整数数列排序
 * 
 * 除最后一个桶只包含数列最大值外， 前面各个桶的区间按照比例来确定。
 * 区间跨度 = （最大值-最小值） / （桶的数量 - 1）
 *
 */
public class BucketSort {

	public static void main(String[] args) {
		double[] array = new double[] {1,6,3,7,2,9,4,8,5};
		System.out.println(Arrays.toString(bucketSort(array)));
	}
	
	private static double[] bucketSort(double[] array) {
		//1.得到数列的最大值和最小值，并算出差值d
		double max = array[0];
		double min = array[0];
		for(int i=1;i<array.length;i++) {
			if(array[i] > max) {
				max = array[i];
			} else if(array[i] < min) {
				min = array[i];
			}
		}
		
		double d = max - min;
		
		//2.初始化桶
		int bucketNum = array.length;
		ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
		for(int i=0;i<bucketNum;i++) {
			bucketList.add(new LinkedList<>());
		}
		
		//3.遍历原始数组，将每个元素放入桶中
		for(int i=0;i<array.length;i++) {
			int num = (int)((array[i] - min) * (bucketNum - 1)/d);
			bucketList.get(num).add(array[i]);
		}
		
		//4.对每个桶内部进行排序
		for(int i=0;i<bucketList.size();i++) {
			Collections.sort(bucketList.get(i));
		}
		
		//5. 输出全部元素
		double[] sortedArray = new double[array.length];
		int index = 0;
		for(LinkedList<Double> list: bucketList) {
			for(double element : list) {
				sortedArray[index++] = element;
			}
		}
		
		return sortedArray;
	}

}
