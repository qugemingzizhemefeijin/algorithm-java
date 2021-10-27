package com.tigerjoys.cg.algorithm.leetcode;

import com.tigerjoys.cg.algorithm.utils.SingleNode;
import com.tigerjoys.cg.algorithm.utils.Tools;

/**
 * 难度：中等
 * 题目：
 * 对链表进行插入排序。
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 */
public class _0147对链表进行插入排序 {

    public static void main(String[] args) {
        SingleNode<Integer> head = Tools.createIntSingleNode(new int[]{6, 5, 3, 1, 8, 7, 2, 4});
        Tools.printNode(insertionSortList1(head));
    }

    // 插入排序的基本思想是，维护一个有序序列，初始时有序序列只有一个元素，每次将一个新的元素插入到有序序列中，将有序序列的长度增加 11，直到全部元素都加入到有序序列中。
    // 如果是数组的插入排序，则数组的前面部分是有序序列，每次找到有序序列后面的第一个元素（待插入元素）的插入位置，将有序序列中的插入位置后面的元素都往后移动一位，然后将待插入元素置于插入位置。

    // 对于单向链表而言，只有指向后一个节点的指针，因此需要从链表的头节点开始往后遍历链表中的节点，寻找插入位置。
    // 对链表进行插入排序的具体过程如下。
    //
    public static SingleNode<Integer> insertionSortList2(SingleNode<Integer> head) {
        if (head == null) {
            return null;
        }
        SingleNode<Integer> dummyHead = new SingleNode<>(0);
        dummyHead.next = head;
        SingleNode<Integer> lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                SingleNode<Integer> prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

    // 递归解法 递归到尾节点，从尾节点开始处理有序区，返回新的头节点
    public static SingleNode<Integer> insertionSortList1(SingleNode<Integer> head) {
        if (head == null || head.next == null) { // 空或单节点，已经有序
            return head;
        }

        SingleNode<Integer> sortedHead = insertionSortList1(head.next); // 递归到尾节点，把右边作为有序区进行插入排序

        SingleNode<Integer> dummy = new SingleNode<>(0); // dummy节点处理头节点的插入
        dummy.next = sortedHead;

        SingleNode<Integer> pre = dummy, greater = sortedHead;
        while (greater != null && head.val > greater.val) { // 找到插入的位置
            pre = pre.next;
            greater = greater.next;
        }

        pre.next = head; // 插入到当前位置
        head.next = greater;

        return dummy.next; // 返回新的头节点

        /*SingleNode<Integer> node = head;

        SingleNode<Integer> next = null;
        SingleNode<Integer> pre = null;
        while(node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }

        return pre;*/
    }

}
