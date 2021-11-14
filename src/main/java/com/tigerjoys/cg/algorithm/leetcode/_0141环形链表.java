package com.tigerjoys.cg.algorithm.leetcode;

import com.tigerjoys.cg.algorithm.utils.ListNode;
import com.tigerjoys.cg.algorithm.utils.Tools;

import java.util.HashSet;
import java.util.Set;

/**
 * 难度：简单
 * 题目：
 *
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 *
 */
public class _0141环形链表 {

    public static void main(String[] args) {
        ListNode head = Tools.createCycleListLink(new int[]{1,2}, -1);
        System.out.println(hasCycle2(head));
    }

    // 每次我们到达一个节点，如果该节点已经存在于哈希表中，则说明该链表是环形链表，否则就将该节点加入哈希表中。
    // 重复这一过程，直到我们遍历完整个链表即可。
    public static boolean hasCycle2(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while(head != null) {
            // add返回为true代表从来没存在过
            if(!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // 两个指针，一个步行1，一个不行2，只要是环形的，两个必能碰到一起。
    public static boolean hasCycle1(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode node = head, node2 = head;
        while(node != null && node2 != null) {
            node = node.next;
            // node2 跳两步
            node2 = node2.next;
            if(node2 == null) {
                return false;
            }
            node2 = node2.next;
            if(node == node2) {
                return true;
            }
        }
        return false;
    }

}
