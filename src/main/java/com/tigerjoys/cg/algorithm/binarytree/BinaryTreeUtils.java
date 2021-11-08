package com.tigerjoys.cg.algorithm.binarytree;

import java.util.LinkedList;

public class BinaryTreeUtils {
	
	public static class TreeNode {
		
		public int data;
		public TreeNode leftChild;
		public TreeNode rightChild;
		
		public TreeNode(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return String.valueOf(data);
		}

	}
	
	/**
	 * 构建二叉树
	 * @param array - 输入序列
	 * @return TreeNode
	 */
	public static TreeNode createBinaryTree(int[] array) {
		TreeNode root = new TreeNode(array[0]);
		createNode(array, 0, root);
		
		return root;
	}
	
	private static void createNode(int[] array, int i, TreeNode parentNode) {
		if(i * 2 + 1 >= array.length) {
			return;
		}
		
		parentNode.leftChild = new TreeNode(array[i * 2 + 1]);
		createNode(array, i * 2 + 1, parentNode.leftChild);
		
		if(i * 2 + 2 >= array.length) {
			return;
		}
		
		parentNode.rightChild = new TreeNode(array[i * 2 + 2]);
		createNode(array, i * 2 + 2, parentNode.rightChild);
	}
	
	/**
	 * 根据Integer数组创建二叉树
	 * @param array - Integer[]
	 * @return TreeNode
	 */
	public static TreeNode createBinaryTree(Integer[] array) {
		if(array == null || array.length == 0) {
			return null;
		}
		if(array.length == 1) {
			return new TreeNode(array[0]);
		}

		TreeNode root = new TreeNode(array[0]);
		createNode(array, 0, root);
		
		return root;
	}
	
	private static void createNode(Integer[] array, int i, TreeNode parentNode) {
		if(i * 2 + 1 >= array.length) {
			return;
		}

		if(array[i * 2 + 1] != null) {
			parentNode.leftChild = new TreeNode(array[i * 2 + 1]);
			createNode(array, i + 1, parentNode.leftChild);
		}

		if(i * 2 + 2 >= array.length) {
			return;
		}

		if(array[i * 2 + 2] != null) {
			parentNode.rightChild = new TreeNode(array[i * 2 + 2]);
			createNode(array, i + 1, parentNode.rightChild);
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
		System.err.println(data);
		if(data != null) {
			node = new TreeNode(data);
			node.leftChild = createBinaryTree(inputList);
			node.rightChild = createBinaryTree(inputList);
		}
		return node;
	}
	
	/**
	 * 按照层序遍历
	 * @param root - TreeNode
	 */
	public static void printLeftRightTree(TreeNode root) {
		int maxDepth = maxDepth(root);
		for(int i=0;i<=maxDepth;i++) {
			_levelOrderTraveral(root, i);
		}
	}
	
	private static void _levelOrderTraveral(TreeNode node, int i) {
		if(node == null || i == 0) {
			return;
		}
		if(i == 1) {
			System.out.print(node.data+",");
			return;
		}
		
		_levelOrderTraveral(node.leftChild, i-1);
		_levelOrderTraveral(node.rightChild, i-1);
	}

	/**
	 * 获取二叉树最大深度
	 * @param root - TreeNode
	 * @return int
	 */
	public static int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int left = maxDepth(root.leftChild);
		int right = maxDepth(root.rightChild);
		
		return Math.max(left, right) + 1;
	}

}
