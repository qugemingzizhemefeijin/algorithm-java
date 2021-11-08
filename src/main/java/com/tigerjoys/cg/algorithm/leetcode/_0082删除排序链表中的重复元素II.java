package com.tigerjoys.cg.algorithm.leetcode;

import com.tigerjoys.cg.algorithm.linked.LinkedUtils;
import com.tigerjoys.cg.algorithm.linked.LinkedUtils.LinkNode;

import java.util.LinkedHashMap;
import java.util.Map;

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
        LinkNode head = LinkedUtils.createLink(new int[]{1, 2, 3, 3, 4, 4, 5});
        LinkedUtils.printOrderLink(deleteDuplicates3(head));
    }

    // 递归
    public static LinkNode deleteDuplicates3(LinkNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        LinkNode right = head;
        int c = 0;
        while(right != null && right.data == head.data) {
            c++;
            right = right.next;
        }

        if(c == 1) {
            head.next = deleteDuplicates3(head.next);
            return head;
        } else {
            return deleteDuplicates3(right);
        }
    }

    // 一次遍历
    public static LinkNode deleteDuplicates2(LinkNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        LinkNode dummy = new LinkNode(-1);
        dummy.next = head;

        LinkNode right = head, left = dummy;
        while(right != null) {
            LinkNode preNode = null;
            int v = right.data;
            int c = 0;
            // 记录一下重复数量，如果为1，则不重复，否则一直到重复的最后一个节点
            while(right != null && v == right.data) {
                c++;
                preNode = right;
                right = right.next;
            }
            // 逻辑其实主要在这里
            if(c == 1) {
                // 如果不重复，需要将当前节点拼接
                left.next = preNode;
                left = left.next;
            } else {
                // 重复的话，则调到重复的指针后面的一个节点
                left.next = right;
            }
        }
        return dummy.next;
    }

    // 还是用LinkedHashMap搞定咯
    public static LinkNode deleteDuplicates1(LinkNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        Map<Integer, Integer> s = new LinkedHashMap<>();
        LinkNode cur = head;
        while(cur != null) {
            Integer v = s.get(cur.data);
            s.put(cur.data, v != null ? v + 1 : 1);
            cur = cur.next;
        }

        LinkNode dummy = new LinkNode(-1), preNode = dummy;
        for(Map.Entry<Integer, Integer> me : s.entrySet()) {
            if(me.getValue() == 1) {
                LinkNode node = new LinkNode(me.getKey());
                preNode.next = node;
                preNode = node;
            }
        }
        return dummy.next;
    }

}
