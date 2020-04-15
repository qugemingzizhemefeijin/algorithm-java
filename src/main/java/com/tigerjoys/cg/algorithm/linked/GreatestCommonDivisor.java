package com.tigerjoys.cg.algorithm.linked;

/**
 * 求两个数的最大公约数
 *
 */
public class GreatestCommonDivisor {
	
	public static void main(String[] args) {
		int a = 100 , b = 30;
		System.out.println(a + "和" + b +"的最大公约数数：" + getGreatestCommonDivisor(a, b));
		System.out.println(a + "和" + b +"的最大公约数数：" + getGreatestCommonDivisor2(a, b));
		System.out.println(a + "和" + b +"的最大公约数数：" + getGreatestCommonDivisor3(a, b));
		System.out.println(a + "和" + b +"的最大公约数数：" + getGreatestCommonDivisor4(a, b));
	}
	
	/**
	 * 求出最大公约数，最简单的，就是先求出a,b哪个小，再暴力循环small的一般开始,能同时被a,b整除，则是最大公约数了
	 * @param a - int
	 * @param b - int
	 * @return int
	 */
	public static int getGreatestCommonDivisor(int a, int b) {
		int big = a > b ? a : b;
		int small = a > b ? b : a;
		
		if(big%small == 0) {
			return small;
		}
		for(int i=small/2;i>1;i--) {
			if(small%i==0 && big % i == 0) {
				return i;
			}
		}
		return 1;
	}
	
	/**
	 * 辗转相除法
	 * 这条算法基于一个定理： 两个正整数a和b（a>b） ， 它们的最大公约数等于a除以b的余数c和b之间的最大公约数。
	 * 例如10和25， 25除以10商2余5， 那么10和25的最大公约数， 等同于10和5的最大公约数。
	 * @param a - int
	 * @param b - int
	 * @return int
	 */
	public static int getGreatestCommonDivisor2(int a, int b) {
		int big = a > b ? a : b;
		int small = a > b ? b : a;
		
		if(big % small == 0) {
			return small;
		}
		
		return getGreatestCommonDivisor2(big%small, small);
	}
	
	/**
	 * 更相减损术
	 * 两个正整数a和b（a>b） ， 它们的最大公约数等于a-b的差值c和较小数b的最大公约数。 
	 * 例如10和25， 25减10的差是15， 那么10和25的最大公约数， 等同于10和15的最大公约数。
	 * @param a - int
	 * @param b - int
	 * @return int
	 */
	public static int getGreatestCommonDivisor3(int a, int b) {
		if(a == b) {
			return a;
		}
		int big = a > b ? a : b;
		int small = a > b ? b : a;
		
		return getGreatestCommonDivisor3(big-small, small);
	}
	
	/**
	 * 把辗转相除法和更相减损术的优势结合起来， 在更相减损术的基础上使用移位运算。众所周知， 移位运算的性能非常好。 
	 * 对于给出的正整数a和b， 不难得到如下的结论。
	 * 
	 * 当a和b均为偶数时， gcd(a,b) = 2×gcd(a/2, b/2) = 2×gcd(a>>1,b>>1)。
	 * 当a为偶数， b为奇数时， gcd(a,b) = gcd(a/2,b) = gcd(a>>1,b)。
	 * 当a为奇数， b为偶数时， gcd(a,b) = gcd(a,b/2) = gcd(a,b>>1)。
	 * 当a和b均为奇数时， 先利用更相减损术运算一次， gcd(a,b) = gcd(b,a-b)， 此时a-b必然是偶数， 然后又可以继续进行移位运算。
	 * @param a - int
	 * @param b - int 
	 * @return int
	 */
	public static int getGreatestCommonDivisor4(int a, int b) {
		if(a == b) {
			return a;
		}
		
		if((a & 1) == 0 && (b & 1) == 0) {
			return getGreatestCommonDivisor4(a>>1, b>>1)<<1;
		} else if((a & 1) == 0 && (b & 1) != 0) {
			return getGreatestCommonDivisor4(a>>1, b);
		} else if((a & 1) != 0 && (b & 1) == 0) {
			return getGreatestCommonDivisor4(a, b>>1);
		} else {
			int big = a > b ? a : b;
			int small = a > b ? b : a;
			
			return getGreatestCommonDivisor4(big-small, small);
		}
	}

}
