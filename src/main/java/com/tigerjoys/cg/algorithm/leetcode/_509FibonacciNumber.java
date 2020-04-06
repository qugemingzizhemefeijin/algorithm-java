package com.tigerjoys.cg.algorithm.leetcode;

public class _509FibonacciNumber {
	
	public static void main(String[] args) {
		System.err.println(fib(2));
	}
	
	public static int fib(int N) {
        if(N <= 1) return N;
        int a = 0, b = 1;
        for (int i = 2; i <= N; ++i) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

}
