package com.tigerjoys.cg.algorithm.binarytree;

import com.tigerjoys.cg.algorithm.binarytree.BinaryTreeUtils.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 对称二叉树 {
	
	public static boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }
	
	private static boolean isMirror(TreeNode t1,TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.data == t2.data)
                && isMirror(t1.leftChild,t2.rightChild)
                && isMirror(t1.rightChild,t2.leftChild);
    }
	
	public static void main(String[] args) {
		//初始化一个对称的二叉树
		int[] a = {1,2,2,3,4,4,3};
		TreeNode root = BinaryTreeUtils.createBinaryTree(a);
		System.out.println("数组A" + (isSymmetric(root)?"是":"不是")+"对称二叉树");
	}

}
