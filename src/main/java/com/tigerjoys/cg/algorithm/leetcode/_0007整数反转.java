package com.tigerjoys.cg.algorithm.leetcode;

/**
 *
 * 难度：简单
 *
 * 题目：给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *
 */
public class _0007整数反转 {

    public static void main(String[] args) {
        System.out.println(reverse1(-123));
        System.out.println(reverse2(-123));
    }

    // 弹栈法，取余数，每次循环的时候将上一次数*10
    private static int reverse2(int x) {
        int ret = 0;
        while(x != 0) {
            if(ret > Integer.MAX_VALUE / 10 || ret < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            ret = ret * 10 + digit;
            x /= 10;
        }
        return ret;
    }

    // 最垃圾解法
    private static int reverse1(int x) {
        String s = String.valueOf(x);
        StringBuilder buf = new StringBuilder();
        for(int i=s.length() -1 ; i>=0 ; i--) {
            if(s.charAt(i) == '-') {
                buf.insert(0, '-');
            } else {
                buf.append(s.charAt(i));
            }
        }
        long l = Long.parseLong(buf.toString());
        return l > Integer.MAX_VALUE || l < Integer.MIN_VALUE ? 0 : (int)l;
    }

}
