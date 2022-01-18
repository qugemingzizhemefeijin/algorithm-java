package com.tigerjoys.cg.algorithm.leetcode;

import com.google.common.collect.Lists;
import com.tigerjoys.cg.algorithm.utils.ListNode;
import com.tigerjoys.cg.algorithm.utils.Tools;

import java.util.List;
import java.util.Objects;

/**
 * 难度：简单
 * 题目：
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * 输入：head = [1,2]
 * 输出：false
 *
 */
public class _0234回文链表 {

    public static void main(String[] args) {
        ListNode head = Tools.createListLink(new int[]{1, 2, 1});
        Tools.printListLink(head);

        System.out.println(isPalindrome1(head));
    }

    // 将值复制到数组中后用双指针法
    public static boolean isPalindrome1(ListNode head) {
        List<Integer> vals = Lists.newArrayList();

        // 将链表的值复制到数组中
        while(head != null) {
            vals.add(head.val);
            head = head.next;
        }

        // 使用双指针判断是否回文
        int left = 0, right = vals.size() - 1;
        while(left < right) {
            if(!Objects.equals(vals.get(left), vals.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
