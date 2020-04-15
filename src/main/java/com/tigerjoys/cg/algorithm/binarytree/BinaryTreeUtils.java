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

}
