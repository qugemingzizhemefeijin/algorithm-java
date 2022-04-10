package com.tigerjoys.cg.algorithm.interview.moka;

import com.tigerjoys.cg.algorithm.utils.ListNode;
import com.tigerjoys.cg.algorithm.utils.Tools;

public class IntersecedLink {

    // 判断两个链表是否相交
    public static void main(String[] args) {
        ListNode headA = Tools.createListLink(new int[]{4, 1, 8, 4, 5});
        ListNode headB = Tools.createListLink(new int[]{5, 6, 1});

        // 循环到最后，相交与8
        ListNode temp = headB;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = headA.next.next;

        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println("相交节点为：" + (intersectionNode != null ? String.valueOf(intersectionNode.val) : "无"));
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA, pB = headB;
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }

}
