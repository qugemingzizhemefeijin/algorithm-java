package com.tigerjoys.cg.algorithm.linked;

public class LinkedUtils {
	
	public static class LinkNode {
		
		public int data;
		public LinkNode pre;
		public LinkNode next;
		
		public LinkNode() {
			
		}
		
		public LinkNode(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "LinkNode [data=" + data + ", pre=" + (pre != null ? pre.data : null) + ", next=" + (next != null ? next.data : null) + "]";
		}
		
	}
	
	/**
	 * 根据数组顺序创建链表
	 * @param array - int[]
	 * @return LinkNode
	 */
	public static LinkNode createLink(int[] array) {
		LinkNode temp = new LinkNode(array[0]);
		LinkNode root = temp;
		for(int i=1;i<array.length;i++) {
			LinkNode node = new LinkNode(array[i]);
			temp.next = node;
			node.pre = temp;
			temp = node;
		}
		
		return root;
	}
	
	/**
	 * 打印链表数据
	 * @param root - LinkNode
	 */
	public static void printOrderLink(LinkNode root) {
		LinkNode temp = root;
		while(temp != null) {
			System.out.print(temp.data+",");
			temp = temp.next;
		}
		System.out.println();
	}

}
