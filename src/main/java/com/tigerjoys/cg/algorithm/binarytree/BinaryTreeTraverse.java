package com.tigerjoys.cg.algorithm.binarytree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 二叉树遍历
 */
public class BinaryTreeTraverse {
	
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
	 * 二叉树前序遍历
	 * @param node - 二叉树节点
	 */
	public static void preOrderTraveral(TreeNode node) {
		if(node == null) {
			return;
		}
		
		System.out.println(node.data);
		preOrderTraveral(node.leftChild);
		preOrderTraveral(node.rightChild);
	}
	
	/**
	 * 二叉树中序遍历
	 * @param node - 二叉树节点
	 */
	public static void inOrderTraveral(TreeNode node) {
		if(node == null) {
			return;
		}
		
		inOrderTraveral(node.leftChild);
		System.out.println(node.data);
		inOrderTraveral(node.rightChild);
	}
	
	/**
	 * 二叉树后序遍历
	 * @param node - 二叉树节点
	 */
	public static void postOrderTraveral(TreeNode node) {
		if(node == null) {
			return;
		}
		postOrderTraveral(node.leftChild);
		postOrderTraveral(node.rightChild);
		System.out.println(node.data);
	}
	
	private static void _levelOrderTraveral(TreeNode node, int i) {
		if(node == null || i == 0) {
			return;
		}
		if(i == 1) {
			System.out.println(node.data);
			return;
		}
		
		_levelOrderTraveral(node.leftChild, i-1);
		_levelOrderTraveral(node.rightChild, i-1);
	}
	
	/**
	 * 二叉树层序遍历
	 * @param node - 二叉树节点
	 */
	public static void levelOrderTraveral(TreeNode node) {
		int deep = treeDepth(node);
		for(int i=0;i<=deep;i++) {
			_levelOrderTraveral(node, i);
		}
	}
	
	private static int treeDepth(TreeNode node) {
		int i = 0, j = 0;
		TreeNode t = node;
		while(t != null) {
			i++;
			t = t.leftChild;
		}
		t = node;
		while(t != null) {
			j++;
			t = t.rightChild;
		}
		
		return i>j?i:j;
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
