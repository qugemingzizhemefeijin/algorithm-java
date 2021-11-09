package com.tigerjoys.cg.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 难度：简单
 * 题目：
 *
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 *
 * 输入: rowIndex = 0
 * 输出: [1]
 *
 * 输入: rowIndex = 1
 * 输出: [1,1]
 *
 */
public class _0119杨辉三角II {

    public static void main(String[] args) {
        System.out.println(getRow(30));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();

        long number = 1;
        for(int i=0;i<=rowIndex;i++) {
            ret.add((int)number);
            number = number * (rowIndex - i) / (i + 1);
        }

        return ret;
    }

}
