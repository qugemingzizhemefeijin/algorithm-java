package com.tigerjoys.cg.algorithm.leetcode;

import com.tigerjoys.cg.algorithm.linked.LinkedUtils;
import com.tigerjoys.cg.algorithm.linked.LinkedUtils.LinkNode;

import java.util.Stack;

/**
 * 难度：中等
 * 题目：给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *
 */
public class _0061旋转链表 {

    public static void main(String[] args) {
        LinkNode head = LinkedUtils.createLink(new int[]{1, 2, 3, 4, 5});
        LinkedUtils.printOrderLink(rotateRight2(head, 2));
    }

    // 闭合为环
    // 我们可以先将给定的链表连接成环，然后将指定位置断开。
    // 我们首先计算出链表的长度 nn，并找到该链表的末尾节点，将其与头节点相连。这样就得到了闭合为环的链表。
    // 然后我们找到新链表的最后一个节点（即原链表的第 (n - 1) - (k mod n) 个节点），将当前闭合为环的链表断开，即可得到我们所需要的结果。
    //
    // 特别地，当链表长度不大于 11，或者 kk 为 nn 的倍数时，新链表将与原链表相同，我们无需进行任何处理。
    public static LinkNode rotateRight2(LinkNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int len = 1;
        LinkNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            len++;
        }
        int add = len - k % len;
        if(add == len) {
            return head;
        }

        iter.next = head;
        while(add-- > 0) {
            iter = iter.next;
        }
        LinkNode ret = iter.next;
        iter.next = null;
        return ret;
    }

    // 我的解法，存储到栈中
    public static LinkNode rotateRight1(LinkNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        LinkNode dummy = new LinkNode(-1);
        dummy.next = head;
        // 获取链表长度
        int len = getLength(head);
        // 获取实际需要的动作
        k = len - k % len;

        // 将链表存储到栈中
        LinkNode node = dummy.next, preNode = dummy;
        Stack<LinkNode> stack = new Stack<>();
        while(node != null) {
            if(k == 0) {
                // 主要是为了解闭环
                preNode.next = null;
                stack.push(node);
            } else {
                k--;
                preNode = preNode.next;
            }
            node = node.next;
        }

        // 然后循环pop出来接续到头节点
        node = dummy.next;
        for(LinkNode n : stack) {
            n.next = node;
            node = n;
        }

        return node;
    }

    private static int getLength(LinkNode head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

}
