package com.tigerjoys.cg.algorithm.leetcode;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 *
 * 难度：low
 * 题目：给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 思路：
 * 最容易想到的方法是枚举数组中的每一个数 x，寻找数组中是否存在 target - x。
 * 创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
 *
 */
public class _0001TwoSum {

    public static void main(String[] args) {
        int[] num = new int[]{2,7,11,15};
        int[] ret = twoSum2(num, 17);
        System.out.println(ret[0] + "," + ret[1]);
    }

    // 暴力破解法
    // 时间复杂度：O(N^2)O(N2)，其中 NN 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。
    private static int[] twoSum1(int[] num, int n) {
        for(int i=0;i<num.length-1;i++) {
            for(int j=i+1;j<num.length;j++) {
                if(num[i] + num[j] == n) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // 哈希表法，可以为0(n)
    // 创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
    private static int[] twoSum2(int[] num, int n) {
        Map<Integer, Integer> m = Maps.newHashMap();
        for(int i=0;i<num.length;i++) {
            if(m.containsKey(n - num[i])) {
                return new int[]{m.get(n - num[i]), i};
            }
            m.put(num[i], i);
        }
        return new int[0];
    }

}
