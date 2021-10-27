package com.tigerjoys.cg.algorithm.leetcode;

import com.tigerjoys.cg.algorithm.utils.Tools;

import java.util.*;

/**
 *
 * 难度：中等
 *
 * 题目：给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 输入：nums = []
 * 输出：[]
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 */
public class _0015三数之和 {

    public static void main(String[] args) {
        // -4, -1, -1, 0, 1, 2
        Tools.printJson(threeSum2(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    // 排序 + 双指针
    // 双指针法铺垫： 先将给定 nums 排序，复杂度为 O(NlogN)O(NlogN)。
    // 双指针法思路： 固定 33 个指针中最左（最小）数字的指针 k，双指针 i，j 分设在数组索引 (k, len(nums))(k,len(nums)) 两端，通过双指针交替向中间移动，记录对于每个固定指针 k 的所有满足 nums[k] + nums[i] + nums[j] == 0 的 i,j 组合：
    // 当 nums[k] > 0 时直接break跳出：因为 nums[j] >= nums[i] >= nums[k] > 0，即 33 个数字都大于 00 ，在此固定指针 k 之后不可能再找到结果了。
    // 当 k > 0且nums[k] == nums[k - 1]时即跳过此元素nums[k]：因为已经将 nums[k - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合。
    // i，j 分设在数组索引 (k, len(nums))(k,len(nums)) 两端，当i < j时循环计算s = nums[k] + nums[i] + nums[j]，并按照以下规则执行双指针移动：
    // 当s < 0时，i += 1并跳过所有重复的nums[i]；
    // 当s > 0时，j -= 1并跳过所有重复的nums[j]；
    // 当s == 0时，记录组合[k, i, j]至res，执行i += 1和j -= 1并跳过所有重复的nums[i]和nums[j]，防止记录到重复组合。

    // 复杂度分析：
    // 时间复杂度 O(N^2)：其中固定指针k循环复杂度 O(N)，双指针 i，j 复杂度 O(N)。
    // 空间复杂度 O(1)：指针使用常数大小的额外空间。
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums == null ? 0 : nums.length;
        if(len < 3) {
            return res;
        }
        //先排序
        Arrays.sort(nums);
        for(int k = 0; k < nums.length - 2; k++){
            // 因为排序了，所以如果当前值为整数，则后面k+1,k+2必须都是整数，所以三数相加不可能为0
            if(nums[k] > 0) break;
            // k - 1的数组合已经包含了 k 后面能计算出来的所有组合了。直接就可以跳过 k了。
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            // 这里开启双指针
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    // 将l指针++并跳过所有重复的nums[i]
                    while(i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    //  将r指针++并跳过所有重复的num[j]
                    while(i < j && nums[j] == nums[--j]);
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }

    // 我的解法，穷举法
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int len = nums.length;
        for(int i=0;i<len-2;i++) {
            for(int j=i+1;j<len-1;j++) {
                for(int k=j+1;k<len;k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> subList = new ArrayList<>();
                        subList.add(nums[i]);
                        subList.add(nums[j]);
                        subList.add(nums[k]);
                        Collections.sort(subList);
                        String key = subList.get(0)+"#"+subList.get(1)+"#"+subList.get(2);
                        if(!set.contains(key)) {
                            list.add(subList);
                            set.add(key);
                        }
                    }
                }
            }
        }
        return list;
    }

}
