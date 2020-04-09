package com.tigerjoys.cg.algorithm.sort;

/**
 * 快速排序，双边循环法
 * 
 * 首先， 选定基准元素pivot， 并且设置两个指针left和right， 指向数列的最左和最右两个元素
 * 
 * 接下来进行第1次循环， 从right指针开始， 让指针所指向的元素和基准元素做比较。 如果大于或等于pivot， 则指针向左移动； 如果小于
 * pivot， 则right指针停止移动， 切换到left指针。在当前数列中， 1<4， 所以right直接停止移动， 换到left指针， 进行下一步行动。
 * 轮到left指针行动， 让指针所指向的元素和基准元素做比较。 如果小于或等于pivot， 则指针向右移动； 如果大于pivot， 则left指针停止移动。
 * 由于left开始指向的是基准元素， 判断肯定相等， 所以left右移1位。
 * 
 * 然后交换left 与 right，再重新循环
 *
 */
public class QuickBilateralSort {
	
	public static void quickSort(int startIndex, int endIndex) {
		// 递归结束条件：startIndex大于或等于endIndex
		if(startIndex >= endIndex) {
			return;
		}
		//得到基准元素位置
		int pivotIndex = partition(startIndex, endIndex);
		//根据基准元素，分成两部分进行递归排序
		quickSort(startIndex, pivotIndex - 1);
		quickSort(pivotIndex + 1, endIndex);
	}
	
	/**
	 * 分治（双边循环法）
	 * @param startIndex
	 * @param endIndex
	 * @return int
	 */
	private static int partition(int startIndex, int endIndex) {
		// 取第1个位置（也可以选择随机位置）的元素作为基准元素
		int pivot = ArrayUtils.SQLIST[startIndex];
		int left = startIndex;
		int right = endIndex;
		while(left != right) {
			//控制right指针比较并左移
			while(left < right && ArrayUtils.SQLIST[right] > pivot) {
				right--;
			}
			
			//控制left指针比较并右移
			while(left < right && ArrayUtils.SQLIST[left] <= pivot) {
				left++;
			}
			
			//交换left和right指针所指向的元素
			if(left < right) {
				ArrayUtils.cryleCounter();
				ArrayUtils.swap(left, right);
			}
		}
		
		//pivot 和指针重合点交换
		ArrayUtils.SQLIST[startIndex] = ArrayUtils.SQLIST[left];
		ArrayUtils.SQLIST[left] = pivot;
		return left;
	}
	
	public static void main(String[] args) {
		QuickBilateralSort.quickSort(0, ArrayUtils.SQLIST.length-1);
		ArrayUtils.print();
	}

}
