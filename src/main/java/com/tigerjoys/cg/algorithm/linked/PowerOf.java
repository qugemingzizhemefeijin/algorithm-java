package com.tigerjoys.cg.algorithm.linked;

/**
 * 判断一个数是否是2个整数次幂
 *
 */
public class PowerOf {
	
	public static void main(String[] args) {
		System.out.println(isPowerOf2(32));
		System.out.println(isPowerOf2(33));
		System.out.println(isPowerOf22(32));
	}
	
	private static boolean isPowerOf2(int num) {
		int temp = 1;
		while(temp <= num) {
			if(temp == num) {
				return true;
			}
			temp = temp << 1;
		}
		return false;
	}
	
	private static boolean isPowerOf22(int num) {
		return (num & (num - 1)) == 0;
	}

}
