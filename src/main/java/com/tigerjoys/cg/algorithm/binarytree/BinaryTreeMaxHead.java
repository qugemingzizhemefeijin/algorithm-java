package com.tigerjoys.cg.algorithm.binarytree;

import java.util.Arrays;

/**
 * 二叉堆（最大堆）
 * @author chengang
 *
 */
public class BinaryTreeMaxHead {
	
	/**
	 * 上浮
	 * @param array
	 */
	private static void upAdjust(int[] array) {
		int childIndex = array.length-1;
		int parentIndex = (childIndex - 1) / 2;
		int temp = array[childIndex];
		while(childIndex > 0 && temp > array[parentIndex]) {
			array[childIndex] = array[parentIndex];
			childIndex = parentIndex;
			parentIndex = (childIndex -1)/2;
		}
		array[childIndex] = temp;
	}
	
	/**
	 * 下沉
	 * @param array
	 * @param parentIndex - 要下沉的父节点
	 * @param length - 堆的有效大小
	 */
	private static void downAdjust(int[] array, int parentIndex, int length) {
		int temp = array[parentIndex];
		//左孩子
		int childIndex = parentIndex*2+1;
		while(childIndex < length) {
			//如果有右孩子，且右孩子比左孩子大，则定位到右孩子
			if(childIndex +1 > length && array[childIndex + 1] > array[childIndex]) {
				childIndex++;
			}
			if(temp >= array[childIndex]) {
				break;
			}
			array[parentIndex] = array[childIndex];
			parentIndex = childIndex;
			childIndex = childIndex*2+1;//左孩子
		}
		array[parentIndex] = temp;
	}
	
	/**
	 * 构建堆
	 * @param array
	 */
	private static void buildHeap(int[] array) {
		// 从最后一个非叶子节点开始，一次做下沉调整
		for(int i=(array.length-2)/2;i>=0;i--) {
			downAdjust(array, i, array.length);
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {10,6,9,5,3,7,8,2,1,4};
		upAdjust(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {7,1,3,10,5,2,8,9,6};
		buildHeap(array);
		System.out.println(Arrays.toString(array));
	}

}
