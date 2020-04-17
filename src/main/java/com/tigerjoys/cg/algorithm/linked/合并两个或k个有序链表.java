package com.tigerjoys.cg.algorithm.linked;

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
public class 合并两个或k个有序链表 {
	
	public static LinkNode mergeTwoLists(LinkNode l1, LinkNode l2) {
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
	
	public static void main(String[] args) {
		LinkNode link1 = LinkedUtils.createLink(new int[] {1,2,4});
		LinkNode link2 = LinkedUtils.createLink(new int[] {1,3,4});
		
		LinkNode head = mergeTwoLists(link1, link2);
		LinkedUtils.printOrderLink(head);
	}

}
