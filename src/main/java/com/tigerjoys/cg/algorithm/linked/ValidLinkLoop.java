package com.tigerjoys.cg.algorithm.linked;

import java.util.Set;

import com.google.common.collect.Sets;
import com.tigerjoys.cg.algorithm.sort.ArrayUtils;
import com.tigerjoys.cg.algorithm.sort.ArrayUtils.Node;

/**
 * 判断一个链表是否有环
 *
 */
public class ValidLinkLoop {

	public static void main(String[] args) {
		Node head = ArrayUtils.initLinkNode(10, 8);
		System.out.println("存在环形链："+valid3(head));
		System.out.println("环的长度："+loopSize(head));
		System.out.println("入环点："+inLoopPoint(head).data);
	}
	
	/**
	 * 第一种是从头开始遍历，写两个循环，如果遍历到相同节点，并且位置不在一个，则代表有环。否则代表无环。
	 * 空间复杂度o(1)，时间复杂度o(n平方)
	 * @param head - Node
	 * @return boolean
	 */
	private static boolean valid1(Node head) {
		int counter = 1;
		for(Node n=head.next;n!=null;n=n.next) {
			counter++;
			int c = 0;
			for(Node n2 = head;n2!=null;n2=n2.next) {
				c++;
				if(counter == c) {
					break;
				} else if(n2 == n) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 第二种就是可以循环将元素放到HashSet中，如果存在，则代表是个环。
	 * 空间复杂度o(n)，时间复杂度o(n)
	 * @param head - Node
	 * @return booean
	 */
	private static boolean valid2(Node head) {
		Set<Node> hashSet = Sets.newHashSet();
		for(Node n = head;n!=null;n=n.next) {
			if(hashSet.contains(n)) {
				return true;
			} else {
				hashSet.add(n);
			}
		}
		return false;
	}
	
	/**
	 * 第三种，就是奇，偶数的追赶，只要是环形，他们肯定能追上彼此。
	 * 空间复杂度o(1)，时间复杂度o(n)
	 * @param head - Node
	 * @return boolean
	 */
	private static boolean valid3(Node head) {
		Node p1 = head , p2 = head;
		while(p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if(p1 == p2) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 求出环的长度，首次相遇到再次相遇 n = (速度差,2-x)*前进次数 = 前进次数
	 * @param head - Node
	 * @return int
	 */
	private static int loopSize(Node head) {
		Node p1 = head, p2 = head;
		int step = 0;
		while(p2 != null && p2.next!=null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if(p1 == p2) {
				if(step > 0) {
					break;
				}
				step++;
			} else {
				if(step > 0) {
					step++;
				}
			}
		}
		return step;
	}
	
	/**
	 * 求出环的入环点，按照步长1,2的两个指针来算的话，n=步长差
	 * 2(D+S1) = D+S1+n(S1+S2)
	 * D = (n-1)(S1+S2)+S2
	 * 入环点其实就是第一次相遇点s1，然后从s1和head开始各启动一个指针，当他们相遇的时候，就是入环点。
	 * @param head - Node
	 * @return Node
	 */
	private static Node inLoopPoint(Node head) {
		Node p1 = head, p2 = head, meet1 = head, meet2 = null;
		boolean meet = false;
		while(p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			
			if(meet) {
				meet1 = meet1.next;
				meet2 = meet2.next;
				
				if(meet1 == meet2) {
					return meet1;
				}
			}
			
			//此处相遇，则需要启动两个指针，分别从p点和head点出发，每次步长为1，直至两个指向同一个点
			if(p1 == p2 && !meet) {
				meet = true;
				meet2 = p1;
			}
		}
		return null;
	}

}
