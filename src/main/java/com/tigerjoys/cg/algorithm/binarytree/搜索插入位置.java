package com.tigerjoys.cg.algorithm.binarytree;

/**
 * 其实就是二分排序后计算出可能插入的位置
 * 
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

	计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class 搜索插入位置 {

	public static int searchInsert(int[] array, int target) {
		int begin = 0;
        int end = array.length;
        
        int result = 0;
        while(begin < end) {
			int mid = (begin + end) >> 1;
        	if(target > array[mid]) {
        		result = begin = mid + 1;
        	} else if(target < array[mid]) {
        		result = end = mid;
        	} else {
        		result = mid;
        		break;
        	}
        }
        
        return result;
	}

	public static void main(String[] args) {
		int[] array = { 1, 3, 5, 6, 10, 65, 88, 99, 102 };
		System.out.println(searchInsert(array, 4));
	}

}
