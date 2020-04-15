package com.tigerjoys.cg.algorithm.linked;

import java.util.Stack;

/**
 * 实现一个栈， 该栈带有出栈（pop） 、 入栈（push） 、 取最小元素（getMin） 3个方法。 要保证这3个方法的时间复杂度都是O(1)。
 * 
 * 一个栈保存数据，一个栈保存最小值
 * 
 * 进栈、 出栈、 取最小值的时间复杂度都是O(1)，最坏情况空间复杂度是O(n)。
 *
 */
public class MinStack {
	
	private Stack<Integer> mainStack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
	
	public void push(Integer o) {
		//如果入栈比辅助栈顶元素小，则入栈
		if(minStack.isEmpty() || minStack.peek().intValue()>=o) {
			minStack.push(o);
		}
		mainStack.push(o);
	}
	
	public Integer pop() {
		//如果出栈的元素与辅助栈顶元素相等，则辅助栈出栈
		if(mainStack.peek().equals(minStack.peek())) {
			minStack.pop();
		}
		return mainStack.pop();
	}
	
	public int getMin() throws Exception {
		if(mainStack.isEmpty()) {
			throw new Exception("stack is empty");
		}
		return minStack.peek();
	}
	
	public static void main(String[] args) throws Exception {
		MinStack s = new MinStack();
		s.push(8);
		s.push(3);
		s.push(3);
		s.push(7);
		s.push(9);
		s.push(2);
		s.push(8);
		s.push(2);
		
		System.out.println(s.getMin());
		s.pop();
		s.pop();
		System.out.println(s.getMin());
		s.pop();
		System.out.println(s.getMin());
	}

}
