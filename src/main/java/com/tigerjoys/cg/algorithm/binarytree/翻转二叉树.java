package com.tigerjoys.cg.algorithm.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.tigerjoys.cg.algorithm.binarytree.BinaryTreeUtils.TreeNode;

/**
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class 翻转二叉树 {
	
	/**
	 * 反转二叉树
	 * @param root - TreeNode
	 */
	public static void invertTree(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode temp = node.leftChild;
			node.leftChild = node.rightChild;
			node.rightChild = temp;

			if (node.leftChild != null) {
				queue.offer(node.leftChild);
			}
			if (node.rightChild != null) {
				queue.offer(node.rightChild);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {4,2,7,1,3,6,9};
		TreeNode root = BinaryTreeUtils.createBinaryTree(array);
		invertTree(root);
		//按照层序输出
		BinaryTreeUtils.printLeftRightTree(root);
	}

}
