package com.tigerjoys.cg.algorithm.interview.moka;

import com.tigerjoys.cg.algorithm.linked.LinkedUtils;
import com.tigerjoys.cg.algorithm.linked.LinkedUtils.LinkNode;

// 单列表反转
public class linkReverse {

    private static LinkNode reverseList(LinkNode root) {
        LinkNode current = root;
        LinkNode next = null, pre = null;
        while(current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
        LinkNode root = LinkedUtils.createLink(array);
        LinkedUtils.printOrderLink(root);
        root = reverseList(root);
        LinkedUtils.printOrderLink(root);
    }

}
