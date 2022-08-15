package com.tigerjoys.cg.algorithm.test;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 例1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 例2：
 * 输入： nums = [3,2,4], target = 6
 * 输出： [1,2]
 *
 * 例3：
 * 输入： nums = [3,3], target = 6
 * 输出： [0,1]
 */
public class _两数之和 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 26;

        System.out.println(Arrays.toString(twoSum2(nums, target)));
    }

    // 暴力解法
    private static int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            // 因为同一元素不允许重复出现，所以从i的下一位开始遍历
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // 利用 map 解，降低时间复杂度
    private static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> s = Maps.newHashMap();
        for (int i = 0; i < nums.length; i++) {
            // 一层遍历，用 target 减去每一项，在 map 的 key 中寻找
            if (s.containsKey(target - nums[i])) {
                return new int[]{s.get(target - nums[i]), i};
            }
            s.put(nums[i], i);
        }
        return null;
    }

}
