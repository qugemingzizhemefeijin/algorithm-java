package com.tigerjoys.cg.algorithm.linked;

/**
 * 一个无序数组里有若干个正整数， 范围是1～100， 其中99个整数都出现了偶数次， 只有1个整数出现了奇数次， 如何找到这个出现奇数次的整数
 * 
 * 使用两两异或，该解法的时间复杂度是O(n)， 空间复杂度是O(1)。
 *
 */
public class SearchLackInt2 {
	
	public static int soulte(int[] array) {
		int c = 0;
		for(int i : array) {
			c = c ^ i;
		}
		return c;
	}
	
	private static int[] create() {
		int[] a = new int[101];
		for(int i=0;i<50;i=i+2) {
			int c = i;
			a[i] = c;
			a[i+1] = c;
		}
		a[100] = 51;
		return a;
	}
	
	public static void main(String[] args) {
		int[] array = create();
		System.out.println("出现奇数为：" + soulte(array));
	}

}
