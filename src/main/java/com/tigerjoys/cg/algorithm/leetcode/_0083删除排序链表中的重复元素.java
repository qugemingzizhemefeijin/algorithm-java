package com.tigerjoys.cg.algorithm.leetcode;

import com.tigerjoys.cg.algorithm.linked.LinkedUtils;
import com.tigerjoys.cg.algorithm.linked.LinkedUtils.LinkNode;

import java.util.LinkedHashSet;

/**
 * 难度：简单
 * 题目：
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 */
public class _0083删除排序链表中的重复元素 {

    public static void main(String[] args) {
        LinkNode head = LinkedUtils.createLink(new int[]{1, 2, 2, 3, 3});
        LinkedUtils.printOrderLink(deleteDuplicates2(head));
    }

    // 一次遍历
    // 由于给定的链表是排好序的，因此重复的元素在链表中出现的位置是连续的，因此我们只需要对链表进行一次遍历，就可以删除重复的元素。
    public static LinkNode deleteDuplicates2(LinkNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        LinkNode cur = head;
        while(cur.next != null) {
            if(cur.data == cur.next.data) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    // 我的解法1，LinkedHashSet解决重复问题，最后再重新构造链表
    public static LinkNode deleteDuplicates1(LinkNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        LinkedHashSet<Integer> s = new LinkedHashSet<>();
        while(head != null) {
            s.add(head.data);
            head = head.next;
        }

        // 构建链表
        LinkNode dummy = new LinkNode(-1);
        LinkNode node = dummy;
        for(Integer i : s) {
            node.next = new LinkNode(i);
            node = node.next;
        }
        return dummy.next;
    }

}
