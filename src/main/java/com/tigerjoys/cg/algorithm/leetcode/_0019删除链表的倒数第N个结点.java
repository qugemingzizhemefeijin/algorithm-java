package com.tigerjoys.cg.algorithm.leetcode;

import com.tigerjoys.cg.algorithm.utils.SingleNode;
import com.tigerjoys.cg.algorithm.utils.Tools;

/**
 *
 * 难度：中等
 * 题目：
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 */
public class _0019删除链表的倒数第N个结点 {

    public static void main(String[] args) {
        SingleNode<Integer> head = Tools.createIntSingleNode(new int[]{1, 2, 3, 4, 5});
        Tools.printNode(removeNthFromEnd(head, 2));
    }

    public static SingleNode<Integer> removeNthFromEnd(SingleNode<Integer> head, int n) {
        return null;
    }

}
