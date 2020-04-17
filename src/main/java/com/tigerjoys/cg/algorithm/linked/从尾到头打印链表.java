package com.tigerjoys.cg.algorithm.linked;

import java.util.Stack;

import com.tigerjoys.cg.algorithm.linked.LinkedUtils.LinkNode;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class 从尾到头打印链表 {
	
	public static void reversePrint(LinkNode head) {
		LinkNode temp = head;
		Stack<Object> s = new Stack<>();
		while(temp != null) {
			s.push(temp.data);
			temp = temp.next;
		}
		
		while(!s.isEmpty()) {
			System.out.print(s.pop()+", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		LinkNode root = LinkedUtils.createLink(array);
		reversePrint(root);
	}

}
