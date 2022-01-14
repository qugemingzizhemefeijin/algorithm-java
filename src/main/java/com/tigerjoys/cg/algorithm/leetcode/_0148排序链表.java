package com.tigerjoys.cg.algorithm.leetcode;

import com.tigerjoys.cg.algorithm.utils.ListNode;
import com.tigerjoys.cg.algorithm.utils.Tools;

/**
 * 难度：中等
 * 题目：
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * 输入：head = []
 * 输出：[]
 *
 */
public class _0148排序链表 {

    public static void main(String[] args) {
        ListNode head = Tools.createListLink(new int[]{4, 2, 1, 3});

        Tools.printListLink(sortList(head));
    }

    // 归并排序（递归法）
    // 通过递归实现链表归并排序，有以下两个环节：
    // 分割 cut 环节： 找到当前链表中点，并从中点将链表断开（以便在下次递归 cut 时，链表片段拥有正确边界）；
    // 1.我们使用 fast,slow 快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点。
    // 2.找到中点 slow 后，执行 slow.next = None 将链表切断。
    // 3.递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
    // 4.cut 递归终止条件： 当head.next == None时，说明只有一个节点了，直接返回此节点。
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

}
