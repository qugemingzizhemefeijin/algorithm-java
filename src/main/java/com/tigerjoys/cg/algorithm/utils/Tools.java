package com.tigerjoys.cg.algorithm.utils;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

public final class Tools {

    public static void printJson(Object o) {
        System.out.println(JSON.toJSON(o));
    }

    public static void printIntArray(int[] arr) {
        if(arr == null || arr.length == 0) {
            System.out.println("[]");
            return;
        }
        StringBuilder buf = new StringBuilder();
        buf.append(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            buf.append(" -> ").append(arr[i]);
        }
        System.out.println(buf.toString());
    }

    public static void printNode(SingleNode<Integer> node) {
        StringBuilder buf = new StringBuilder();
        buf.append(node.val);
        node = node.next;
        while(node != null) {
            buf.append(" -> ").append(node.val);
            node = node.next;
        }
        System.out.println(buf.toString());
    }

    /**
     * 构造Integer类型的单向链表
     * @param nums int[]
     * @return SingleNode<Integer> 返回首节点
     */
    public static SingleNode<Integer> createIntSingleNode(int[] nums) {
        SingleNode<Integer> root = new SingleNode<>(nums[0], null);

        if(nums.length > 1) {
            SingleNode<Integer> temp = root;
            for(int i=1;i<nums.length;i++) {
                SingleNode<Integer> node = new SingleNode<>(nums[i], null);
                temp.next = node;
                temp = node;
            }
        }

        return root;
    }

    /**
     * 构造Integer类型的单向链表
     * @param nums  Stack<Integer>
     * @param order true顺序，false逆序
     * @return SingleNode<Integer> 返回首节点
     */
    public static SingleNode<Integer> createIntSingleNode(Stack<Integer> nums, boolean order) {
        if(order) {
            SingleNode<Integer> root = new SingleNode<>(nums.get(0), null);
            if(nums.size() > 1) {
                SingleNode<Integer> temp = root;
                for(int i=1;i<nums.size();i++) {
                    SingleNode<Integer> node = new SingleNode<>(nums.get(i), null);
                    temp.next = node;
                    temp = node;
                }
            }
            return root;
        } else {
            SingleNode<Integer> root = new SingleNode<>(nums.pop(), null);
            if(!nums.isEmpty()) {
                SingleNode<Integer> temp = root;
                while(!nums.isEmpty()) {
                    SingleNode<Integer> node = new SingleNode<>(nums.pop(), null);
                    temp.next = node;
                    temp = node;
                }
            }
            return root;
        }
    }

    private Tools() {}

}
