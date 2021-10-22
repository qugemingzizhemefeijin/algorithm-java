package com.tigerjoys.cg.algorithm.leetcode;

/**
 * 斐波那契数列
 *
 * 1、1、2、3、5、8、13、21、34
 */
public class _509FibonacciNumber {
	
	public static void main(String[] args) {
		System.err.println(fib(6));
        System.err.println(fibRecursion(6));
        System.err.println(fibArray(6));
	}

	// 循环法
	public static int fib(int n) {
        if (n < 1) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int a = 0, b = 1;
        for (int i = 2; i <= n; ++i) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    // 递归法
    public static int fibRecursion(int n) {
	    if(n <1) {
	        return -1;
        }
        if(n <= 2) {
            return 1;
        }

        return fibRecursion(n-1) + fibRecursion(n-2);
    }

    // 数组法
    public static int fibArray(int n) {
        if (n < 1) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int[] arr = new int[n];
        arr[0] = arr[1] = 1;//第一个和第二个数据特殊处理
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i -2] + arr[i - 1];
        }

        return arr[n - 1];
    }

}
