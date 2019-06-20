package com.tigerjoys.cg.algorithm.linked;

/**
 * 
 * 单链表反转
 * 
 * Copyright 2019 by lizehd.com
 * Created on 2019年6月20日 下午5:45:27
 *
 * @author chengang
 *
 */
public class SingleLinkedReverse {
	
	public static void main(String[] args) {
		Node node = initLinked();
		//print(node);
		Node newNode = recursionReverseLinked(node);
		print(newNode);
	}
	
	/**
	 * 递归法
	 * @param node - 头部节点
	 * @return Node 新的头部节点
	 */
	private static Node recursionReverseLinked(Node node) {
		if(node == null || node.next == null) {
			return node;
		} else {
			Node preNode = recursionReverseLinked(node.next);
			node.next.next = node;
			node.next = null;
			
			return preNode;
		}
	}
	
	/**
	 * 交换法
	 * @param head - 头部节点
	 * @return Node 新的头部节点
	 */
	private static Node reverseLinked(Node head) {
		Node currNode = head;
		Node prevNode = null;
		Node headNode = null;
		
		while(currNode != null) {
			Node nextNode = currNode.next;
	        if (nextNode == null) {
	            headNode = currNode;
	        }
			
	        currNode.next = prevNode;
	        prevNode = currNode;
	        currNode = nextNode;
		}
		
		return headNode;
	}
	
	private static void print(Node node) {
		while(node != null) {
			System.out.println(node.value);
			node = node.next;
		}
	}
	
	private static Node initLinked() {
		Node last = null;
		Node node = null;
		
		for(int i=10;i>0;i--) {
			node = new Node();
			node.value = String.valueOf(i);
			node.next = last;
			
			last = node;
		}
		
		return node;
	}
	
	private static class Node {
		
		private String value;
		private Node next;
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		
	}

}
