package com.tigerjoys.cg.algorithm.interview.moka;

import com.tigerjoys.cg.algorithm.binarytree.BinaryTreeUtils.TreeNode;

public class AddBinaryTreeAndForeach {

    // 用面向对象的方式构建一棵二叉树，子节点都为1，父节点为子节点的和
    // 并使用先序遍历的方式打印出树的节点
    public static void main(String[] args) {
        TreeNode treeNode = createBinaryTree(14);
        printXianxu(treeNode);
    }

    public static void printXianxu(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + ",");
        printXianxu(node.leftChild);
        printXianxu(node.rightChild);
    }

    public static TreeNode createBinaryTree(int len) {
        TreeNode root = new TreeNode();
        root.data = createNode(0, len, root);

        return root;
    }

    private static int createNode(int i, int len, TreeNode parentNode) {
        if (i * 2 + 1 >= len) {
            return 1;
        }
        // 构造左子树
        parentNode.leftChild = new TreeNode();
        parentNode.leftChild.data = createNode(i * 2 + 1, len, parentNode.leftChild);

        if (i * 2 + 2 >= len) {
            return parentNode.leftChild.data;
        }
        // 构造右子树
        parentNode.rightChild = new TreeNode();
        parentNode.rightChild.data = createNode(i * 2 + 2, len, parentNode.rightChild);

        return parentNode.leftChild.data + parentNode.rightChild.data;
    }

}
