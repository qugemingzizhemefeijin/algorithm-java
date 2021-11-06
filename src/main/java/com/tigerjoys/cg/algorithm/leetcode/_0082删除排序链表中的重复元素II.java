package com.tigerjoys.cg.algorithm.leetcode;

import com.tigerjoys.cg.algorithm.linked.LinkedUtils;
import com.tigerjoys.cg.algorithm.linked.LinkedUtils.LinkNode;

/**
 * 难度：中等
 * 题目：
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * 返回同样按升序排列的结果链表。
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *
 */
public class _0082删除排序链表中的重复元素II {

    public static void main(String[] args) {
        LinkNode head = LinkedUtils.createLink(new int[]{1, 2, 3, 4, 5});
        LinkedUtils.printOrderLink(deleteDuplicates1(head));
    }

    public static LinkNode deleteDuplicates1(LinkNode head) {
        return null;
    }

}
