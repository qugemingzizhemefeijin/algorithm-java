package com.tigerjoys.cg.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * 难度：中等
 * 题目：
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 *
 */
public class _0016最接近的三数之和 {

    public static void main(String[] args) {
        System.out.println(threeSumClosest2(new int[]{46,-80,39,81,-44,22,76,-65,-11,71,-93,0,22,-85,-6,-6,34,-22,33,80,-2,93,-58,-89,-72,19,-47,-30,-14,92,25,5,16,98,62,-26,-11,7,8,4,22,-11,9,-3,55,78,-24,-38,-43,-57,-46,-35,34,93,4,23,-86,61,-74,-18,91,8,-10,89,15,24,94,84,67,37,4,-30,-26,85,-21,95,64,26,49,27,25,91,42,-79,-83,-12,-41,9,0,-100,62,66,96,66,-72,-7,-76,82,38,-58}, -89));
    }

    // 实际还是需要排序 + 双指针
    // 首先进行数组排序，时间复杂度 O(nlogn)
    // 在数组 nums 中，进行遍历，每遍历一个值利用其下标i，形成一个固定值 nums[i]
    // 再使用前指针指向 start = i + 1 处，后指针指向 end = nums.length - 1 处，也就是结尾处
    // 根据 sum = nums[i] + nums[start] + nums[end] 的结果，判断 sum 与目标 target 的距离，如果更近则更新结果 ans
    // 同时判断 sum 与 target 的大小关系，因为数组有序，如果 sum > target 则 end--，如果 sum < target 则 start++，如果 sum == target 则说明距离为 0 直接返回结果
    // 整个遍历过程，固定值为 n 次，双指针为 n 次，时间复杂度为 O(n^2)
    public static int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if (sum > target)
                    end--;
                else if (sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }

    // 我自己的解法，感觉可以获取到所有的三数之和，最后获取最靠近他的的值
    public static int threeSumClosest1(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length-2;i++) {
            for(int j=i+1;j<nums.length-1;j++) {
                for(int k=j+1;k<nums.length;k++) {
                    //System.out.println(nums[i] + "=" + nums[j] + "=" + nums[k]);
                    set.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int c = 0;
        for(int i : set) {
            int d = 0;
            if (target > 0) {
                d = i > 0 ? Math.abs(target - i) : Math.abs(i - target);
            } else {
                d = i > 0 ? Math.abs(target - i) : Math.abs(target - i);
            }
            if(d < min) {
                min = d;
                c = i;
            }
        }
        return c;
    }

}
