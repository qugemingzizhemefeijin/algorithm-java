package com.tigerjoys.cg.algorithm.leetcode;

import com.tigerjoys.cg.algorithm.binarytree.BinaryTreeUtils;
import com.tigerjoys.cg.algorithm.binarytree.BinaryTreeUtils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 难度：简单
 * 题目：给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * 输入：root = []
 * 输出：[]
 *
 * 输入：root = [1]
 * 输出：[1]
 *
 */
public class _0094二叉树的中序遍历 {

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtils.createBinaryTree(new Integer[]{1,null,2,3});
        System.out.println(inorderTraversal2(root));
    }

    // 迭代
    // 方法一的递归函数我们也可以用迭代的方式实现，两种方式是等价的，区别在于递归的时候隐式地维护了一个栈，而我们在迭代的时候需要显式地将这个栈模拟出来，其他都相同
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.leftChild;
            }
            root = stack.pop();
            res.add(root.data);
            root = root.rightChild;
        }
        return res;
    }

    // 中序遍历
    // 首先我们需要了解什么是二叉树的中序遍历：按照访问左子树——根节点——右子树的方式遍历这棵树，而在访问左子树或者右子树的时候我们按照同样的方式遍历，直到遍历完整棵树。
    // 因此整个遍历过程天然具有递归的性质，我们可以直接用递归函数来模拟这一过程。

    // 定义 inorder(root) 表示当前遍历到 root 节点的答案，那么按照定义，我们只要递归调用 inorder(root.left) 来遍历 root 节点的左子树，
    // 然后将 root 节点的值加入答案，再递归调用inorder(root.right) 来遍历 root 节点的右子树即可，递归终止的条件为碰到空节点。
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal1(root, list);
        return list;
    }

    /**
     * 中序遍历
     */
    private static void inorderTraversal1(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }
        if(node.leftChild != null) {
            inorderTraversal1(node.leftChild, list);
        }
        list.add(node.data);
        if(node.rightChild != null) {
            inorderTraversal1(node.rightChild, list);
        }
    }

}
