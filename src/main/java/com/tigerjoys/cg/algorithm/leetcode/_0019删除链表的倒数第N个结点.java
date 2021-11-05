package com.tigerjoys.cg.algorithm.leetcode;

import com.tigerjoys.cg.algorithm.utils.SingleNode;
import com.tigerjoys.cg.algorithm.utils.Tools;

import java.util.Stack;

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
        Tools.printNode(head);
        Tools.printNode(removeNthFromEnd4(head, 2));
    }

    // 双指针法
    // 先让一个指针跑N步，然后后面两个指针一起跑
    // 最后第一个指针到达终点后，其第二个指针指向的就是要删除的节点的上一个节点
    public static SingleNode<Integer> removeNthFromEnd4(SingleNode<Integer> head, int n) {
        SingleNode<Integer> dummy = Tools.createDummyNode(head);

        SingleNode<Integer> first = dummy, second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while(first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }

    // 方法二：栈
    // 我们也可以在遍历链表的同时将所有节点依次入栈。根据栈「先进后出」的原则，我们弹出栈的第 n 个节点就是需要删除的节点，并且目前栈顶的节点就是待删除节点的前驱节点。
    public static SingleNode<Integer> removeNthFromEnd3(SingleNode<Integer> head, int n) {
        SingleNode<Integer> dummy = Tools.createDummyNode(head);
        Stack<SingleNode<Integer>> s = new Stack<>();
        SingleNode<Integer> curr = dummy;
        while(curr != null) {
            s.push(curr);
            curr = curr.next;
        }

        // 弹出N次集合
        SingleNode<Integer> delNode = null, preNode = null;
        for (int i = 0; i < n; i++) {
            delNode = s.pop();
        }
        preNode = s.pop();

        preNode.next = delNode.next;

        return dummy.next;
    }

    // 方法一：计算链表长度
    // 一种容易想到的方法是，我们首先从头节点开始对链表进行一次遍历，得到链表的长度 L。
    // 随后我们再从头节点开始对链表进行一次遍历，当遍历到第 L-n+1 个节点时，它就是我们需要删除的节点。
    // 为了方便删除操作，我们可以从哑节点开始遍历 L-n+1 个节点。当遍历到第 L-n+1 个节点时，它的下一个节点就是我们需要删除的节点，这样我们只需要修改一次指针，就能完成删除操作。
    public static SingleNode<Integer> removeNthFromEnd2(SingleNode<Integer> head, int n) {
        SingleNode<Integer> dummy = new SingleNode<>(0, head);
        SingleNode<Integer> currNode = head;
        // 获取长度
        int len = 0;
        while(currNode != null) {
            len++;
            currNode = currNode.next;
        }

        currNode = dummy;
        for (int i = 0; i < len - n; i++) {
            currNode = currNode.next;
        }
        currNode.next = currNode.next.next;

        return dummy.next;
    }

    // 我自己完成的，应该使用两个指针来追加，最后删除节点
    public static SingleNode<Integer> removeNthFromEnd1(SingleNode<Integer> head, int n) {
        int firstPointer = 0;
        SingleNode<Integer> secondNode = null, node = head, preNode = null;
        while(node != null) {
            firstPointer++;
            if(firstPointer >= n) {
                preNode = secondNode;
                secondNode = firstPointer == n ? head : secondNode.next;
            }
            node = node.next;
        }

        // 更换next指针
        if(preNode != null) {
            preNode.next = secondNode.next;
        } else {
            head = head.next;
        }

        return head;
    }

}
