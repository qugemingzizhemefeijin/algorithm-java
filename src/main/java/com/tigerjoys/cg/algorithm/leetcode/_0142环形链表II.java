package com.tigerjoys.cg.algorithm.leetcode;

import com.google.common.collect.Sets;
import com.tigerjoys.cg.algorithm.utils.ListNode;
import com.tigerjoys.cg.algorithm.utils.Tools;

import java.util.Set;

/**
 * 难度：中等
 *
 * 题目：
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环
 * ，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
 *
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 */
public class _0142环形链表II {

    public static void main(String[] args) {
        ListNode head = Tools.createCycleListLink(new int[]{1,2,3,4,5,6}, 2);
        System.out.println(detectCycle1(head).val);
    }

    // 哈希表思路
    public static ListNode detectCycle1(ListNode head) {
        Set<ListNode> visited = Sets.newHashSet();
        while(head != null) {
            if(visited.contains(head)) {
                return head;
            }
            visited.add(head);
            head = head.next;
        }
        return null;
    }

    // 快慢指针
    // 当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
    public static ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

}
