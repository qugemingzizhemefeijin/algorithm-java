package com.tigerjoys.cg.algorithm.sort;

import java.util.Map;
import java.util.Stack;

import com.google.common.collect.Maps;

/**
 * 快速排序栈调用法
 * 
 * 绝大多数的递归逻辑， 都可以用栈的方式来代替。
 * 
 * 为什么这样说呢？
 * 
 * 代码中一层一层的方法调用， 本身就使用了一个方法调用栈。 每次进入一个新方法， 就相当于入栈； 每次有方法返回， 就相当于出栈。
 * 所以， 可以把原本的递归实现转化成一个栈的实现， 在栈中存储每一次方法调用的参数。
 *
 */
public class QuickStackSort {
	
	public static void quickSort(int startIndex, int endIndex) {
		//用一个集合栈来代替递归的函数栈
		Stack<Map<String, Integer>> quickSortStack = new Stack<>();
		// 整个数列的起止下标入栈
		Map<String, Integer> rootMap = Maps.newHashMap();
		rootMap.put("startIndex", startIndex);
		rootMap.put("endIndex", endIndex);
		quickSortStack.push(rootMap);
		
		while(!quickSortStack.isEmpty()) {
			ArrayUtils.cryleCounter();
			Map<String, Integer> param = quickSortStack.pop();
			// 得到基准元素
			int pivotIndex = partition(param.get("startIndex"), param.get("endIndex"));
			
			//计算左侧数列
			if(param.get("startIndex") < pivotIndex - 1) {
				Map<String , Integer> v = Maps.newHashMap();
				v.put("startIndex", startIndex);
				v.put("endIndex", pivotIndex - 1);
				quickSortStack.push(v);
			}
			
			//计算右侧数列
			if(param.get("endIndex") > pivotIndex + 1) {
				Map<String , Integer> v = Maps.newHashMap();
				v.put("endIndex", pivotIndex +1);
				v.put("startIndex", param.get("endIndex"));
				quickSortStack.push(v);
			}
		}
	}
	
	/**
	 * 分治(单边循环)
	 */
	private static int partition(int startIndex, int endIndex) {
		//取第一个位置的元素
		int pivot = ArrayUtils.SQLIST[startIndex];
		int mark = startIndex;
		
		for(int i=startIndex+1;i<=endIndex;i++) {
			ArrayUtils.cryleCounter();
			if(ArrayUtils.SQLIST[i] < pivot) {
				mark++;
				ArrayUtils.swap(i, mark);
			}
		}
		
		ArrayUtils.swap(mark, startIndex);
		return mark;
	}
	
	public static void main(String[] args) {
		QuickStackSort.quickSort(0, ArrayUtils.SQLIST.length-1);
		ArrayUtils.print();
	}

}
