package com.tigerjoys.cg.algorithm.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树非递归遍历
 *
 */
public class BinaryTreeNoRecursiveTraverse {
	
	private static class TreeNode {
		int data;
		TreeNode leftChild;
		TreeNode rightChild;
		
		TreeNode(int data) {
			this.data = data;
		}
	}
	
	/**
	 * 构建二叉树
	 * @param inputList - 输入序列
	 * @return TreeNode
	 */
	public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
		TreeNode node = null;
		if(inputList == null || inputList.isEmpty()) {
			return null;
		}
		
		Integer data = inputList.removeFirst();
		if(data != null) {
			node = new TreeNode(data);
			node.leftChild = createBinaryTree(inputList);
			node.rightChild = createBinaryTree(inputList);
		}
		return node;
	}
	
	/**
	 * 前序遍历
	 */
	public static void preOrderTraveral(TreeNode node) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode treeNode = node;
		while(treeNode != null || !stack.isEmpty()) {
			while(treeNode != null) {
				System.out.println(treeNode.data);
				stack.add(treeNode);
				treeNode = treeNode.leftChild;
			}
			if(!stack.isEmpty()) {
				treeNode = stack.pop();
				treeNode = treeNode.rightChild;
			}
		}
	}

	/**
	 * 中序遍历
	 */
	public static void inOrderTraveral(TreeNode node) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode treeNode = node;
		while(treeNode != null || !stack.isEmpty()) {
			while(treeNode != null) {
				stack.add(treeNode);
				treeNode = treeNode.leftChild;
			}
			if(!stack.isEmpty()) {
				treeNode = stack.pop();
				System.out.println(treeNode.data);
				treeNode = treeNode.rightChild;
			}
		}
	}

	/**
	 * 后序遍历
	 */
	public static void postOrderTraveral(TreeNode node) {
		Stack<TreeNode> flag = new Stack<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode treeNode = node;
		while(treeNode != null || !flag.isEmpty()) {
			if(treeNode != null) {
				flag.add(treeNode);
				stack.add(treeNode);
				treeNode = treeNode.rightChild;
			} else {
				treeNode = flag.pop();
				treeNode = treeNode.leftChild;
			}
		}
		
		while(stack.size() > 0) {
			TreeNode t = stack.pop();
			System.out.println(t.data);
		}
	}
	
	/**
	 * 层序遍历
	 */
	public static void levelOrderTraveral(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(node);
		while(!queue.isEmpty()) {
			TreeNode treeNode = queue.poll();
			System.out.println(treeNode.data);
			if(treeNode.leftChild != null) {
				queue.offer(treeNode.leftChild);
			}
			if(treeNode.rightChild != null) {
				queue.offer(treeNode.rightChild);
			}
		}
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[] {3,2,9,null,null,10,null,null,8,null,4}));
		TreeNode treeNode = createBinaryTree(inputList);
		
		System.out.println("前序遍历：");
		preOrderTraveral(treeNode);
		System.out.println("中序遍历：");
		inOrderTraveral(treeNode);
		System.out.println("后序遍历：");
		postOrderTraveral(treeNode);
		System.out.println("层序遍历：");
		levelOrderTraveral(treeNode);
	}

}
