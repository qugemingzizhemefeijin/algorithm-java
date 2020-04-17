package com.tigerjoys.cg.algorithm.linked;

import com.tigerjoys.cg.algorithm.linked.LinkedUtils.LinkNode;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 *  
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class 链表中倒数第k个结点 {
	
	public static LinkNode getKthFromEnd(LinkNode head, int k) {
		int step = 0;
		LinkNode temp = head;
		while(head != null) {
			head = head.next;
			step++;
			if(step > k) {
				temp = temp.next;
			}
		}
		return temp;
	}
	
	public static LinkNode getKthFromEnd2(LinkNode head, int k) {
		int step = 0;
		LinkNode fast = head , slow = head;
		for(;step < k;step++) {
			fast = fast.next;
		}
		
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5};
		LinkNode head = LinkedUtils.createLink(array);
		LinkNode node = getKthFromEnd(head, 2);
		LinkedUtils.printOrderLink(node);
		LinkNode node2 = getKthFromEnd2(head, 2);
		LinkedUtils.printOrderLink(node2);
	}

}
