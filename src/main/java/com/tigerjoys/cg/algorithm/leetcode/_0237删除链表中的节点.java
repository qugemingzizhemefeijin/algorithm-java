package com.tigerjoys.cg.algorithm.leetcode;

import com.tigerjoys.cg.algorithm.utils.ListNode;
import com.tigerjoys.cg.algorithm.utils.Tools;

/**
 * 难度：简单
 * 题目：
 * 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。
 * 题目数据保证需要删除的节点 不是末尾节点 。
 *
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：指定链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9
 *
 * 输入：head = [4,5,1,9], node = 1
 * 输出：[4,5,9]
 * 解释：指定链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9
 *
 * 输入：head = [1,2,3,4], node = 3
 * 输出：[1,2,4]
 *
 * 输入：head = [0,1], node = 0
 * 输出：[1]
 *
 * 输入：head = [-3,5,-99], node = -3
 * 输出：[5,-99]
 *
 */
public class _0237删除链表中的节点 {

    public static void main(String[] args) {
        ListNode head = Tools.createListLink(new int[]{4, 5, 1, 9});
        Tools.printListLink(head);
        deleteNode(head.next);
        Tools.printListLink(head);
    }

    // 和下一个节点交换，如 4519 ，将下一个节点的1替换为5，则4119，然后删除第三个节点即可
    // 既然不是尾节点，则next必不为空
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
