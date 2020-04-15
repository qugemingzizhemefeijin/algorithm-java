package com.tigerjoys.cg.algorithm.linked;

import java.util.Stack;

/**
 * 栈模拟队列
 *
 */
public class StackImitateQueue {
	
	private Stack<Integer> stackA = new Stack<>();
	private Stack<Integer> stackB = new Stack<>();
	
	/**
	 * 入队操作
	 * @param element - 入队元素
	 */
	public void enQueue(int element) {
		stackA.push(element);
	}
	
	public Integer deQueue() {
		if(stackB.isEmpty()) {
			if(stackA.isEmpty()) {
				return null;
			}
			transfer();
		}
		return stackB.pop();
	}
	
	/**
	 * 将栈A元素转移到栈B
	 */
	private void transfer() {
		while(!stackA.isEmpty()) {
			stackB.push(stackA.pop());
		}
	}
	
	public static void main(String[] args) {
		StackImitateQueue stackQueue = new StackImitateQueue();
		stackQueue.enQueue(1);
		stackQueue.enQueue(2);
		stackQueue.enQueue(3);
		System.out.println(stackQueue.deQueue());
		System.out.println(stackQueue.deQueue());
		stackQueue.enQueue(4);
		System.out.println(stackQueue.deQueue());
		System.out.println(stackQueue.deQueue());
	}

}
