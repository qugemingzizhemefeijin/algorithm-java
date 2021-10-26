package com.tigerjoys.cg.algorithm.leetcode;

/**
 *
 * 难度：简单
 *
 * 题目：编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 */
public class _0014最长公共前缀 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix1(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix2(new String[]{"dog", "racecar", "car"}));
    }

    // 横向扫描
    // 依次遍历字符串数组中的每个字符串，对于每个遍历到的字符串，更新最长公共前缀，当遍历完所有的字符串以后，即可得到字符串数组中的最长公共前缀。
    public static String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if(prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private static String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int idx = 0;
        while(idx < length && str1.charAt(idx) == str2.charAt(idx)) {
            idx++;
        }
        return idx == 0 ? "" : str1.substring(0, idx);
    }

    // 自己实现的，双重循环
    public static String longestCommonPrefix1(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }

        int idx = 0;
        StringBuilder buf = new StringBuilder();
        top : while(true) {
            char pre = strs[0].charAt(idx);
            for (int i = 1; i < strs.length; i++) {
                if(strs[i].length() <= idx || pre != strs[i].charAt(idx)) {
                    break top;
                }
            }
            buf.append(pre);
            idx++;
        }
        return buf.toString();
    }

}
