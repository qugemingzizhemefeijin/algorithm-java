package com.tigerjoys.cg.algorithm.leetcode;

import com.tigerjoys.cg.algorithm.utils.ListNode;
import com.tigerjoys.cg.algorithm.utils.Tools;

import java.util.HashSet;
import java.util.Set;

/**
 * 难度：简单
 * 题目：
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 *
 */
public class _160相交链表 {

    public static void main(String[] args) {
        ListNode headA = Tools.createListLink(new int[]{4, 1, 8, 4, 5});
        ListNode headB = Tools.createListLink(new int[]{5, 6, 1});

        // 循环到最后，相交与8
        ListNode temp = headB;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = headA.next.next;

        // 造成相交了
        Tools.printListLink(headA);
        Tools.printListLink(headB);

        ListNode intersectionNode = getIntersectionNode1(headA, headB);
        System.out.println("相交节点为：" + (intersectionNode != null ? String.valueOf(intersectionNode.val) : "无"));

        intersectionNode = getIntersectionNode2(headA, headB);
        System.out.println("相交节点为：" + (intersectionNode != null ? String.valueOf(intersectionNode.val) : "无"));
    }

    // 双指针法，A,B指针先分别指向，当移到最后一个，则交换，如果相加，则必然他们会相等，否则肯定不相等
    private static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    // 判断两个链表是否相交，可以使用哈希集合存储链表节点。
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

}
