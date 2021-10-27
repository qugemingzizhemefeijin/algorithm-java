package com.tigerjoys.cg.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 难度：中等
 * 题目：
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。（就是老式功能机的九宫格输入法）
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * 输入：digits = ""
 * 输出：[]
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 */
public class _0017电话号码的字母组合 {

    public static void main(String[] args) {
        System.out.println(letterCombinations1("23"));
    }

    // 回溯算法
    public static List<String> letterCombinations1(String digits) {
        List<String> list = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return list;
        }

        Map<Character, String> maps = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "hij");
            put('5', "klm");
            put('6', "nop");
            put('7', "qrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backtrack(list, maps, digits, 0, new StringBuilder());
        return list;
    }

    public static void backtrack(List<String> list, Map<Character, String> maps, String digits, int index, StringBuilder combination) {
        if(index == digits.length()) {
            list.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = maps.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(list, maps, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

}
