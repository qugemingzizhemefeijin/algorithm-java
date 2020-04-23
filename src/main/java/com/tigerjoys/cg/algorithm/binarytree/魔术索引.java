package com.tigerjoys.cg.algorithm.binarytree;

/**
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
 * 给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 *
 * 示例1:
 *
 *  输入：nums = [0, 2, 3, 4, 5]
 *  输出：0
 *  说明: 0下标的元素为0
 * 示例2:
 *
 *  输入：nums = [1, 1, 1]
 *  输出：1
 * 提示:
 *
 * nums长度在[1, 1000000]之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/magic-index-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class 魔术索引 {
	
	public static void main(String[] args) {
		int array[] = {2,2,2,3};
        int magicIndex = findMagicIndex(array);
        System.out.println("magicIndex:" + magicIndex);
        magicIndex = findMagicIndex2(array);
        System.out.println("magicIndex:" + magicIndex);
        System.out.println(Math.sqrt(28));
	}
	
	/**
	 * 既然给的数组是有序的，我们理应充分利用这个条件。
	 * 
	 * 你看你会发现这个问题与经典的二分查找问题非常相似。充分运用匹配法，就能找到适当的算法，我们又该怎样运用二分查找法呢？
	 * 在二分查找中，要找出元素k，我们会先拿它跟数组中间的元素x比较，确定k位于x的左边还是右边。
	 * 以此为基础，是否通过检查中间元素就能确定魔术索引的位置？
	 * 
	 * 通过比较A[mid]<mid，可以确定该魔术索引一定在mid的右边，因此left=mid+1;
	 * 如果A[mid]>mid，可以取得该魔术索引一定在mid 的左边，因此right=mid-1；
	 * 
	 * 这个解法只能找到魔术索引，但是不能找到最小的
	 * @param array - int[]
	 * @return int
	 */
	private static int findMagicIndex(int[] array) {
		int left = 0, right = array.length;
		while(left <= right) {
			int mid = (left + right) >> 1;
			if(array[mid] < mid) {
				left = mid + 1;
			} else if(array[mid] > mid) {
				right = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	/**
	 * 还是从0索引开始遍历，不过当前索引指向的元素如果大于当前索引的话，下次遍历就从该元素处遍历，因为数组是有序的，意味着至少到该元素处才有可能出现魔术索引。
	 * 
	 * @param array
	 * @return
	 */
	private static int findMagicIndex2(int[] array) {
		int idx = 0;
		while(idx < array.length) {
			if(array[idx] == idx) {
				return idx;
			} else if(array[idx] > idx) {
				idx = array[idx];
			} else {
				idx++;
			}
		}
		return -1;
	}

}
