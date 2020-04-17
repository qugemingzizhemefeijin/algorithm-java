package com.tigerjoys.cg.algorithm.linked;

import com.tigerjoys.cg.algorithm.linked.LinkedUtils.LinkNode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *  
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class 反转链表 {

	public static LinkNode reverseList(LinkNode head) {
		LinkNode current = head;
		LinkNode pre = null, next = null;
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
