package com.tigerjoys.cg.algorithm.leetcode;

import com.tigerjoys.cg.algorithm.utils.ListNode;
import com.tigerjoys.cg.algorithm.utils.Tools;

/**
 * 难度：简单
 * 题目：
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 */
public class _0206反转链表 {

    public static void main(String[] args) {
        ListNode head = Tools.createListLink(new int[]{1, 2, 3, 4, 5});

        ListNode newHead = reverseList2(head);
        Tools.printListLink(newHead);
    }

    // 指针反转
    public static ListNode reverseList1(ListNode head) {
        ListNode curr = head;
        ListNode next, pre = null;
        while(curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;

            curr = next;
        }

        return pre;
    }

    // 递归法
    public static ListNode reverseList2(ListNode head) {
        return reverseList(head, null);
    }

    private static ListNode reverseList(ListNode curr, ListNode pre) {
        if(curr == null) {
            return pre;
        }
        ListNode next = curr.next;
        curr.next = pre;
        return reverseList(next, curr);
    }

}
