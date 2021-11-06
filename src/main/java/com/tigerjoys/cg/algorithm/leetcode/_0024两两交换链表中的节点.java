package com.tigerjoys.cg.algorithm.leetcode;

import com.tigerjoys.cg.algorithm.linked.LinkedUtils;
import com.tigerjoys.cg.algorithm.linked.LinkedUtils.LinkNode;

/**
 * 难度：中等
 * 题目：
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 输入：head = []
 * 输出：[]
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 */
public class _0024两两交换链表中的节点 {

    public static void main(String[] args) {
        LinkNode head = LinkedUtils.createLink(new int[]{1, 2, 3, 4});
        LinkedUtils.printOrderLink(swapPairs3(head));
    }

    // 迭代
    // 也可以通过迭代的方式实现两两交换链表中的节点。
    public static LinkNode swapPairs3(LinkNode head) {
        LinkNode dummyHead = new LinkNode(-1);
        dummyHead.next = head;
        LinkNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            LinkNode node1 = temp.next;
            LinkNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    // 递归
    // 可以通过递归的方式实现两两交换链表中的节点。
    // 递归的终止条件是链表中没有节点，或者链表中只有一个节点，此时无法进行交换。
    // 如果链表中至少有两个节点，则在两两交换链表中的节点之后，原始链表的头节点变成新的链表的第二个节点，原始链表的第二个节点变成新的链表的头节点。
    // 链表中的其余节点的两两交换可以递归地实现。在对链表中的其余节点递归地两两交换之后，更新节点之间的指针关系，即可完成整个链表的两两交换。
    public static LinkNode swapPairs2(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode newHead = head.next;
        head.next = swapPairs2(newHead.next);
        newHead.next = head;
        return newHead;
    }

    // 我自己的解法，使用递归 + 分治
    public static LinkNode swapPairs1(LinkNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        LinkNode dummy = new LinkNode(-1);
        dummy.next = head;

        LinkNode node = dummy.next, pre = dummy;
        while(node != null && node.next != null) {
            swap(pre, node, node.next);
            pre = node;
            node = node.next;
        }

        return dummy.next;
    }

    private static void swap(LinkNode pre, LinkNode l, LinkNode r) {
        if(l == null || r == null) {
            return;
        }
        LinkNode rnext = r.next;
        pre.next = r;
        r.next = l;
        l.next = rnext;
    }

}
