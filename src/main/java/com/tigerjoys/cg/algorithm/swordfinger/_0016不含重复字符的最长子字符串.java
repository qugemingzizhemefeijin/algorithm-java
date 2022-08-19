package com.tigerjoys.cg.algorithm.swordfinger;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 *
 * 难度：中等
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 */
public class _0016不含重复字符的最长子字符串 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    // 滑动窗口
    private static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;

        int left = 0;//左端点
        Map<Character, Integer> map = Maps.newHashMap();
        int len = 0;
        for (int i = 0; i < n; i++) {//右端点
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);//向map中添加元素
            len++;
            System.out.println(c + "," + len + "," + map);
            while (map.get(c) > 1) {//发现有重复元素，左指针拉过来，直到没有重复元素
                len--;
                char l = s.charAt(left++);
                map.put(l, map.get(l) - 1);
            }
            ans = Math.max(ans, len);//更新答案
        }

        return ans;
    }

}
