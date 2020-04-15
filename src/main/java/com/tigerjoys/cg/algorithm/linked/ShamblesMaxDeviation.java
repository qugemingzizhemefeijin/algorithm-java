package com.tigerjoys.cg.algorithm.linked;

import java.util.HashMap;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tigerjoys.cg.algorithm.sort.ArrayUtils;

/**
 * 一组无序数组的最大两两差值
 *
 */
public class ShamblesMaxDeviation {
	
	public static void main(String[] args) {
		int[] array = new int[] {8, 7, 17, 6, 42, 100};
		System.out.println("解法1:" + solution1(array));
		System.out.println("解法2:" + solution2(array));
		System.out.println("解法3:" + solution3(array));
	}
	
	/**
	 * 解法1，先排序，后两两相邻计算差值
	 * @param array - int[]
	 * @return int
	 */
	private static int solution1(int[] array) {
		//此处先排序
		quickSort(array, 0, array.length-1);
		
		//两两相减
		int max = 0;
		for(int i=1;i<array.length;i++) {
			if(array[i] - array[i-1] > max) {
				max = array[i] - array[i-1];
			}
		}
		
		return max;
	}
	
	private static void quickSort(int[] array, int startIndex, int endIndex) {
		if(startIndex >= endIndex) {
			return;
		}
		int pt = partition(array, startIndex, endIndex);
		
		quickSort(array, 0, pt -1);
		quickSort(array, pt + 1, endIndex);
	}
	
	//求出分割值
	private static int partition(int[] array, int startIndex, int endIndex) {
		int pivot = array[startIndex];
		int mark = startIndex;
		for(int i=startIndex+1;i<=endIndex;i++) {
			if(array[i] < pivot) {
				mark++;
				ArrayUtils.swap(array, mark, i);
			}
		}
		ArrayUtils.swap(array, mark, startIndex);
		return mark;
	}
	
	/**
	 * 解法2：按照计数排序，将数据分到对应坐标中，然后计算连续为0的坐标数量，最大的则是最大差值
	 * @param array - int[]
	 * @return int
	 */
	public static int solution2(int[] array) {
		//1. 求出最大值和最小值
		int min = array[0], max = array[0];
		for(int i=1;i<array.length;i++) {
			if(min > array[i]) {
				min = array[i];
			} else if(max < array[i]) {
				max = array[i];
			}
		}
		//2. 求出查出，并初始化计数数组
		int d = max - min;
		int[] countArray = new int[d + 1];
		for(int i=0;i<array.length;i++) {
			countArray[array[i] - min]++;
		}
		//3. 求出最后的差值
		int diff = 1;
		max = 0;
		for(int i=0;i<countArray.length;i++) {
			if(countArray[i] == 0) {
				diff++;
			} else if(diff > 0) {
				if(diff > max) {
					max = diff;
				}
				diff=1;
			}
		}
		return max;
	}
	
	/**
	 * 解法3，按照桶排序思路，计算相邻两个桶之间的最大值和最小值的差值即可。
	 * @param array - int[]
	 * @return int
	 */
	public static int solution3(int[] array) {
		//1. 得到数列的最大值和最小值
		int min = array[0] , max = array[0];
		for(int i=1;i<array.length;i++) {
			if(min > array[i]) {
				min = array[i];
			} else if(max < array[i]) {
				max = array[i];
			}
		}
		int d = max - min;
		//相等则说明所有元素都是一个值，直接返回0
		if(d == 0) {
			return 0;
		}
		//2. 初始化桶
		int bucketNum = array.length;
		List<HashMap<String, Integer>> buckets = Lists.newArrayListWithCapacity(bucketNum);
		for(int i=0;i<bucketNum;i++) {
			buckets.add(Maps.newHashMap());
		}
		//3. 遍历原始数组，确定每个桶的最大最小值
		for(int i=0;i<bucketNum;i++) {
			int index = (array[i] - min) * (bucketNum - 1) / d;
			if(buckets.get(index).get("min") == null || buckets.get(index).get("min") > array[i]) {
				buckets.get(index).put("min", array[i]);
			}
			if(buckets.get(index).get("max") == null || buckets.get(index).get("max") < array[i]) {
				buckets.get(index).put("max", array[i]);
			}
		}
		
		//4. 遍历桶，找到最大差值
		int leftMax = buckets.get(0).get("max");
		int maxDistance = 0;
		for(int i=1;i<bucketNum;i++) {
			if(buckets.get(i).isEmpty()) {
				continue;
			}
			if(buckets.get(i).get("min") - leftMax > maxDistance) {
				maxDistance = buckets.get(i).get("min") - leftMax;
			}
			leftMax = buckets.get(i).get("max");
		}
		
		return maxDistance;
	}

}
