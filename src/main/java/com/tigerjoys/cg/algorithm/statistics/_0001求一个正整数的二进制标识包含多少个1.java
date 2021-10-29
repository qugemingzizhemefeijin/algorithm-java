package com.tigerjoys.cg.algorithm.statistics;

public class _0001求一个正整数的二进制标识包含多少个1 {

    public static void main(String[] args) {
        System.out.println(hammingWeight1(4));
        System.out.println(hammingWeight2(4));
    }

    // 位移法
    public static int hammingWeight1(int n) {
        int i = 0, ret = 0;
        while(i < 32) {
            if((n & 1) == 1) {
                ret++;
            }
            n = n >> 1;
            i++;
        }
        return ret;
    }

    // 求与法
    public static int hammingWeight2(int n) {
        int ret = 0;
        while(n > 0) {
            ret++;
            n &= (n - 1);
        }
        return ret;
    }

}
