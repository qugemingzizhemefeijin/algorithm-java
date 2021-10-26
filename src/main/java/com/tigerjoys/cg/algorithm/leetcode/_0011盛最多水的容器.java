package com.tigerjoys.cg.algorithm.leetcode;

/**
 *
 * 难度：中等
 *
 * 题目：给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * 输入：height = [1,1]
 * 输出：1
 *
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 *
 * 输入：height = [1,2,1]
 * 输出：2
 *
 */
public class _0011盛最多水的容器 {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea1(height));
        System.out.println(maxArea2(height));
    }

    // leetcode 的双指针法
    // 在初始时，左右指针分别指向数组的左右两端
    // 此时我们需要移动一个指针。移动哪一个呢？直觉告诉我们，应该移动对应数字较小的那个指针（即此时的左指针）。这是因为，由于容纳的水量是由
    //     两个指针指向的数字中较小值 * 指针之间的距离
    // 决定的。如果我们移动数字较大的那个指针，那么前者「两个指针指向的数字中较小值」不会增加，后者「指针之间的距离」会减小，那么这个乘积会减小。
    // 因此，我们移动数字较大的那个指针是不合理的。因此，我们移动 数字较小的那个指针。
    //
    public static int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int ret = 0;
        while(l <= r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ret = Math.max(ret, area);
            if(height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ret;
    }

    // 穷举法，最low实现
    public static int maxArea1(int[] height) {
        int ret = 0;
        for(int i=0;i<height.length;i++) {
            int max = height[i];
            for(int j=i+1;j<height.length;j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
            ret = Math.max(ret, max);
        }
        return ret;
    }

}
