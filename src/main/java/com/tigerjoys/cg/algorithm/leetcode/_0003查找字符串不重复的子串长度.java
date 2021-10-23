package com.tigerjoys.cg.algorithm.leetcode;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;

/**
 *
 * 难度：medium
 *
 * 题目：给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 输入: s = ""
 * 输出: 0
 *
 * 思路：
 *
 */
public class _0003查找字符串不重复的子串长度 {

    public static void main(String[] args) {
        String s = "bsdfsdfbbb";

        System.out.println(resolveThree(s));
    }

    private static int resolveThree(String s) {
        int len = s.length();
        if(len == 0) {
            return len;
        }

        int ret = 0;
        // 这个是存储同样的字符的位置点，可以用于快速定位
        Map<Character, Integer> map = Maps.newHashMap();
        for (int i = 0, j = 0; j < len; j++) {
            Character c = s.charAt(j);
            if(map.containsKey(c)) {
                i = Math.max(map.get(c), i);// 此处的i记录最大的不重复的值
            }
            ret = Math.max(ret, j - i + 1);
            map.put(c, j + 1);
        }
        return ret;
    }

    // 如果确定子串s[i,j]（假设表示字符串的第i个字符到第j-1个字符表示的子串），那么只需要比较s[j]是否与子串s[i,j]重复即可
    // 若重复：记录此时滑动窗口大小，并与最大滑动窗口比较，赋值。然后滑动窗口大小重定义为1，头位置不变，并右移一个单位。
    // 若不重复：滑动窗口头不变，结尾+1，整个窗口加大1个单位。继续比较下一个。
    private static int resolveTwo(String s) {
        int len = s.length();
        if(len == 0) {
            return len;
        }

        Set<Character> sv = Sets.newHashSet();
        int ret = 0, i = 0, j = 0;
        while(i < len && j < len) {
            if(!sv.contains(s.charAt(j))) {
                sv.add(s.charAt(j++));
                ret = Math.max(ret, j - i);
            } else {
                sv.remove(s.charAt(i++));
            }
        }
        return ret;
    }

    // 暴力解法 检测某字符串的子串中的所有字符都是唯一的（无重复字符）
    private static int resolveOne(String s) {
        int len = s.length();
        if(len == 0) {
            return len;
        }
        int ret = 0;
        for(int i=0;i<len;i++) {
            for(int j=i+1;j<=len;j++) {
                if(uniqChar(s, i, j)) ret = Math.max(ret, j - i);
            }
        }

        return ret;
    }

    private static boolean uniqChar(String s, int i, int j) {
        Set<Character> sv = Sets.newHashSet();
        for(int x=i;x<j;x++) {
            if(!sv.add(s.charAt(x))) {
                return false;
            }
        }
        return true;
    }

}
