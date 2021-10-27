package com.tigerjoys.cg.algorithm.swordfinger;

import com.tigerjoys.cg.algorithm.utils.Tools;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 难度：中等
 *
 * 题目：给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 输入: n = 1, k = 1
 * 输出: [[1]]
 *
 * 提示:
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 */
public class _0080含有k个元素的组合 {

    public static void main(String[] args) {
        Tools.printJson(combine(5, 3));
    }

    // 回溯算法
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(1, list, new ArrayList<>(), n, k);
        return list;
    }

    private static void backtrack(int j, List<List<Integer>> list, List<Integer> _list, int n, int k) {
        // 如果凑足了，则直接加入到大的列表中
        if (_list.size() == k) {
            list.add(new ArrayList<>(_list));
        } else {
            for (int i = j; i <= n; i++) {
                // 每次将自己加进来
                _list.add(i);
                backtrack(i + 1, list, _list, n, k);
                // 又将自己移走
                _list.remove(new Integer(i));
            }
        }
    }

}
