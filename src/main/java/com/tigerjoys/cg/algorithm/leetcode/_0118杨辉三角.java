package com.tigerjoys.cg.algorithm.leetcode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 难度：简单
 * 题目：
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * 1 <= numRows <= 30
 *
 */
public class _0118杨辉三角 {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            ret.add(rowList);
            int number = 1;
            // 打印空格字符串
            //System.out.format("%" + (numRows - i) * 2 + "s", "");
            for (int j = 0; j <= i; j++) {
                //System.out.format("%4d", number);
                rowList.add(number);
                number = number * (i - j) / (j + 1);
            }
        }

        return ret;
    }

}
