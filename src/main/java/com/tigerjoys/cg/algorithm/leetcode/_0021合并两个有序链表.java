package com.tigerjoys.cg.algorithm.leetcode;

import com.tigerjoys.cg.algorithm.linked.LinkedUtils;
import com.tigerjoys.cg.algorithm.linked.LinkedUtils.LinkNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class _0021合并两个有序链表 {

	public static void main(String[] args) {
		LinkNode link1 = LinkedUtils.createLink(new int[] {1,2,4});
		LinkNode link2 = LinkedUtils.createLink(new int[] {1,3,4});

		LinkNode head = mergeTwoLists3(link1, link2);
		LinkedUtils.printOrderLink(head);
	}

	// 方法二：迭代
	// 我们可以用迭代的方法来实现上述算法。当 l1 和 l2 都不是空链表时，判断 l1 和 l2 哪一个链表的头节点的值更小
	// 将较小值的节点添加到结果里，当一个节点被添加到结果里之后，将对应链表中的节点向后移一位。

	// 首先，我们设定一个哨兵节点 prehead ，这可以在最后让我们比较容易地返回合并后的链表。我们维护一个 prev 指针，我们需要做的是调整它的 next 指针。
	// 然后，我们重复以下过程，直到 l1 或者 l2 指向了 null ：如果 l1 当前节点的值小于等于 l2 ，我们就把 l1 当前的节点接在 prev 节点的后面同时将 l1 指针往后移一位。
	// 否则，我们对 l2 做同样的操作。不管我们将哪一个元素接在了后面，我们都需要把 prev 向后移一位。
	//
	// 在循环终止的时候， l1 和 l2 至多有一个是非空的。由于输入的两个链表都是有序的，所以不管哪个链表是非空的，它包含的所有元素都比前面已经合并链表中的所有元素都要大。
	// 这意味着我们只需要简单地将非空链表接在合并链表的后面，并返回合并链表即可。
	public static LinkNode mergeTwoLists3(LinkNode l1, LinkNode l2) {
		LinkNode prehead = new LinkNode(-1);

		LinkNode prev = prehead;
		while(l1 != null && l2 != null) {
			if(l1.data <= l2.data) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}

		// 这里要注意，有可能l1,l2还会多余一个节点
		if(l1 != null) {
			prev.next = l1;
		} else if(l2 != null) {
			prev.next = l2;
		}

		return prehead.next;
	}

	// 方法一：递归
	// 两个链表头部值较小的一个节点与剩下元素的 merge 操作结果合并。
	// 如果 l1 或者 l2 一开始就是空链表 ，那么没有任何操作需要合并，所以我们只需要返回非空链表。
	// 否则，我们要判断 l1 和 l2 哪一个链表的头节点的值更小，然后递归地决定下一个添加到结果里的节点。如果两个链表有一个为空，递归结束。
	public static LinkNode mergeTwoLists2(LinkNode l1, LinkNode l2) {
		if(l1 == null) {
			return l2;
		} else if(l2 == null) {
			return l1;
		} else if(l1.data < l2.data) {
			l1.next = mergeTwoLists2(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists2(l1, l2.next);
			return l2;
		}
	}

	// 原来我自己写的，太垃圾咯
	public static LinkNode mergeTwoLists1(LinkNode l1, LinkNode l2) {
		LinkNode head = new LinkNode(0);
		LinkNode temp = head;
		LinkNode f1 = l1, f2 = l2;
		while(f1 != null || f2 != null) {
			if(f1 == null && f2 != null) {
				temp.next = f2;
				temp = temp.next;
				f2 = f2.next;
			} else if(f1 != null && f2 == null) {
				temp.next = f1;
				temp = temp.next;
				f1 = f1.next;
			} else {
				if(f1.data <= f2.data) {
					temp.next = f1;
					temp = temp.next;
					f1 = f1.next;
				} else {
					temp.next = f2;
					temp = temp.next;
					f2 = f2.next;
				}
			}
		}
		
		return head.next;
	}

}
