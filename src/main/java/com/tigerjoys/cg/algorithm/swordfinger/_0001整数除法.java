package com.tigerjoys.cg.algorithm.swordfinger;

/**
 * 难度：简单
 * 题目：给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 *
 * 注意：
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231−1]。本题中，如果除法结果溢出，则返回 231 − 1
 *
 * 输入：a = 15, b = 2
 * 输出：7
 * 解释：15/2 = truncate(7.5) = 7
 *
 * 输入：a = 7, b = -3
 * 输出：-2
 * 解释：7/-3 = truncate(-2.33333..) = -2
 *
 * 输入：a = 0, b = 1
 * 输出：0
 *
 * 输入：a = 1, b = 1
 * 输出：1
 *
 */
public class _0001整数除法 {

    public static void main(String[] args) {
        System.out.println(divide1(15, 2));
    }

    // 减法代替除法
    // 因为将 -2147483648 转成正数会越界，但是将 2147483647 转成负数，则不会
    // 所以，我们将 a 和 b 都转成负数
    // 时间复杂度：O(n)，n 是最大值 2147483647 --> 10^10 --> 超时
    public static int divide1(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        // 环境只支持存储 32 位整数
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        // 相当于 -15 经过 7次 - -2 = -1 , -1 大于 -2则不再循环了，将res返回即可
        while (a <= b) {
            a -= b;
            res++;
        }
        // bug 修复：因为不能使用乘号，所以将乘号换成三目运算符
        return sign == 1 ? res : -res;
    }

}
