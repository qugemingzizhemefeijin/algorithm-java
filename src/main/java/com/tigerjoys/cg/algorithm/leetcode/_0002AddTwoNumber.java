package com.tigerjoys.cg.algorithm.leetcode;

import com.tigerjoys.cg.algorithm.utils.SingleNode;
import com.tigerjoys.cg.algorithm.utils.Tools;

import java.util.Stack;

/**
 *
 * 难度：medium
 *
 * 题目：给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 思路：
 * 由于输入的两个链表都是逆序存储数字的位数的，因此两个链表中同一位置的数字可以直接相加。
 * 每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值
 * 如果两个链表全部遍历完毕后，进位值为 11，则在新链表最前方添加节点 11
 *
 * 对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。
 * 使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
 *
 */
public class _0002AddTwoNumber {

    public static void main(String[] args) {
        SingleNode<Integer> node1 = Tools.createIntSingleNode(new int[]{2, 4, 3});
        SingleNode<Integer> node2 = Tools.createIntSingleNode(new int[]{5, 6, 4});

        SingleNode<Integer> addNode = addTwoNumbers(node1, node2);
        Tools.printNode(addNode);
    }

    public static SingleNode<Integer> addTwoNumbers(SingleNode<Integer> l1, SingleNode<Integer> l2) {
        SingleNode<Integer> pre = new SingleNode<>(0, null);
        SingleNode<Integer> curr = pre;

        int carry = 0;
        while(l1 != null || l2 != null) {
            int i1 = l1 != null ? l1.val : 0;
            int i2 = l2 != null ? l2.val : 0;
            int sum = i1 + i2 + carry;

            carry = sum / 10;
            sum = sum % 10;

            curr.next = new SingleNode<>(sum);
            curr = curr.next;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry == 1) {
            curr.next = new SingleNode<>(1);
        }

        return pre.next;
    }

    // 自己写的。。low
    public static SingleNode<Integer> addTwoNumbersLower(SingleNode<Integer> l1, SingleNode<Integer> l2) {
        Stack<Integer> s1 = createStack(l1);
        Stack<Integer> s2 = createStack(l2);

        Stack<Integer> s3 = new Stack<>();
        boolean jinwei = false;
        while(true) {
            boolean b1 = s1.isEmpty(), b2 = s2.isEmpty();
            if(b1 && b2) {
                break;
            }
            if(!b1 && !b2) {
                int i1 = s1.pop(), i2 = s2.pop();
                int h = i1 + i2 + (jinwei ? 1 : 0);
                if(h >= 10) {
                    s3.add(h % 10);
                    jinwei = true;
                    continue;
                } else {
                    s3.add(h);
                }
            } else if(!b1) {
                int h = s1.pop() + (jinwei ? 1 : 0);
                if(h >= 10) {
                    s3.add(h % 10);
                    jinwei = true;
                    continue;
                } else {
                    s3.add(h);
                }
            } else {
                int h = s2.pop() + (jinwei ? 1 : 0);
                if(h >= 10) {
                    s3.add(h % 10);
                    jinwei = true;
                    continue;
                } else {
                    s3.add(h);
                }
            }
            jinwei = false;
        }
        if(jinwei) {
            s3.add(1);
        }
        return Tools.createIntSingleNode(s3, true);
    }

    private static Stack<Integer> createStack(SingleNode<Integer> node) {
        Stack<Integer> s = new Stack<>();
        do {
            s.add(node.val);
            node = node.next;
        } while(node != null);
        return s;
    }

}
