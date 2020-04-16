package com.tigerjoys.cg.algorithm.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.tigerjoys.cg.algorithm.binarytree.BinaryTreeUtils.TreeNode;

/**
 * 
 * 
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class 左叶子节点之和 {
	
	private static int sumOfLeftLeaves(TreeNode node) {
		if(node == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        
        int sum = 0;
        while(!queue.isEmpty()) {
        	TreeNode curNode = queue.poll();
        	if (curNode.leftChild != null) {
        		if(curNode.leftChild.leftChild == null && curNode.leftChild.rightChild == null) {
        			sum += curNode.leftChild.data;
        		} else {
        			queue.offer(curNode.leftChild);
        		}
        	}
        	if(curNode.rightChild != null) {
        		queue.offer(curNode.rightChild);
        	}
        }
        return sum;
	}
	
	public static void main(String[] args) {
		Integer[] array = { 3, 9, 20, null, null, 15, 7 };
		TreeNode root = BinaryTreeUtils.createBinaryTree(array);
		System.out.println("所有左叶子之和为：" + sumOfLeftLeaves(root));
	}

}
