package com.tigerjoys.cg.algorithm.leetcode;

import com.tigerjoys.cg.algorithm.linked.LinkedUtils;
import com.tigerjoys.cg.algorithm.linked.LinkedUtils.LinkNode;

/**
 * 难度：困难
 * 题目：
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 输入：lists = []
 * 输出：[]
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 */
public class _0023合并K个升序链表 {

    public static void main(String[] args) {
        LinkNode link1 = LinkedUtils.createLink(new int[]{1, 4, 5});
        LinkNode link2 = LinkedUtils.createLink(new int[]{2, 6});
        LinkNode link3 = LinkedUtils.createLink(new int[]{1, 3, 4});

        LinkNode[] links = new LinkNode[]{link1, link2, link3};

        LinkNode head = mergeKLists2(links);
        LinkedUtils.printOrderLink(head);
    }

    // 方法一：顺序合并
    // 按照原来的两个有序链表，一直合并，有点像for循环的方式，性能会比较差
    public static LinkNode mergeKLists1(LinkNode[] lists) {
        LinkNode head = null;
        for (LinkNode list : lists) {
            head = mergeTwoLists(head, list);
        }
        return head;
    }

    // 方法二：分治合并
    // 就是两两合并
    public static LinkNode mergeKLists2(LinkNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public static LinkNode merge(LinkNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    private static LinkNode mergeTwoLists(LinkNode a, LinkNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }

        LinkNode dummy = new LinkNode(-1);
        LinkNode preNode = dummy;
        while(a != null && b != null) {
            if(a.data <= b.data) {
                preNode.next = a;
                a = a.next;
            } else {
                preNode.next = b;
                b = b.next;
            }
            preNode = preNode.next;
        }

        preNode.next = a != null ? a : b;
        return dummy.next;
    }

}
