package com.tigerjoys.cg.algorithm.binarytree;

import com.tigerjoys.cg.algorithm.binarytree.BinaryTreeUtils.TreeNode;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class 相同的树 {
	
	private static boolean sameTree(TreeNode root1 , TreeNode root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		if(root1 == null || root2 == null) {
			return false;
		}
		if (root1.data != root2.data) {
			return false;
		}
		
		return sameTree(root1.leftChild, root2.leftChild) && sameTree(root1.rightChild, root2.rightChild);
	}
	
	public static void main(String[] args) {
		int[] aa = {1,2,3};
		int[] bb = {1,2,4};
		TreeNode a1 = BinaryTreeUtils.createBinaryTree(aa);
		TreeNode a2 = BinaryTreeUtils.createBinaryTree(bb);
		
		System.out.println("aa和bb"+(sameTree(a1,a2)?"是":"不是")+"相同树");
	}

}
