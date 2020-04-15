package com.tigerjoys.cg.algorithm.linked;

/**
 * 
 * 假设一个无序数组里有若干个正整数， 范围是1～100， 其中有98个整数出现了偶数次， 只有2个整数出现了奇数次， 如何找到这2个出现奇数次的整数？
 * 
 * 把2个出现了奇数次的整数命名为A和B。 遍历整个数组， 然后依次做异或运算， 进行异或运算的最终结果， 等同于A和B进行异或运算的结果。
 * 在这个结果中， 至少会有一个二进制位是1（如果都是0， 说明A和B相等， 和题目不相符） 。
 *  
 * 假设数组长度是n， 那么该解法的时间复杂度是O(n)。 把数组分成两部分， 并不需要借助额外的存储空间， 
 * 完全可以在按二进制位分组的同时来做异或运算， 所以空间复杂度仍然是O(1)。 
 *
 */
public class SearchLackInt3 {
	
	public static int[] findLostNum(int[] array) {
		//用于存储2个出现奇数次的整数
		int result[] = new int[2];
		//第1次进行整体异或运算
		int xorResult = 0;
		for (int i = 0; i < array.length; i++) {
			xorResult ^= array[i];
		}
		//如果进行异或运算的结果为0， 则说明输入的数组不符合题目要求
		if (xorResult == 0) {
			return null;
		}
		//确定2个整数的不同位， 以此来做分组
		int separator = 1;
		while (0 == (xorResult & separator)) {
			separator <<= 1;
		}
		//第2次分组进行异或运算
		for (int i = 0; i < array.length; i++) {
			if (0 == (array[i] & separator)) {
				result[0] ^= array[i];
			} else {
				result[1] ^= array[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] array = { 4, 1, 2, 2, 5, 1, 4, 3 };
		int[] result = findLostNum(array);
		System.out.println(result[0] + "," + result[1]);
	}

}
