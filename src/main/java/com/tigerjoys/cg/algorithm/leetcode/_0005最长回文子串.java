package com.tigerjoys.cg.algorithm.leetcode;

/**
 *
 * 难度：medium
 *
 * 题目：给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *
 * 思路：
 *
 * 扩展中心法：
 * 我们知道回文串一定是对称的，所以我们可以每次循环选择一个中心，进行左右扩展，判断左右字符是否相等即可。
 * 由于存在奇数的字符串和偶数的字符串，所以我们需要从一个字符开始扩展，或者从两个字符之间开始扩展，所以总共有 n+n-1 个中心。
 *
 * 时间复杂度：O(n²）
 * 空间复杂度：O(1）
 *
 */
public class _0005最长回文子串 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        if(s.length() == 1) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 扩展中心1 奇数
            int len1 = expandAroundCenter(s, i, i);
            // 扩展中心2 偶数
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            //只有找到比上次更大的长度的回文字符串才更新start 和 end值
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
            System.out.println("len = " + len + " , start = " + start + ", end = " + end);
        }
        return s.substring(start, end + 1);
    }

    /**
     * 扩展中心方法，就是left 和 right 互相减少和新增，判断两边的字母是否是一致的
     * @return 返回L和R之间的间隔数，其实就是回文字符长度
     */
    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
