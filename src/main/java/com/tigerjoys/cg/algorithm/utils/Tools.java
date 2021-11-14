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
        if(node == null) {
            System.out.println("[]");
            return;
        }
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

    /**
     * 创建一个哑节点
     * @param head 哑节点的next节点
     * @return SingleNode<Integer>
     */
    public static SingleNode<Integer> createDummyNode(SingleNode<Integer> head) {
        return new SingleNode<>(0, head);
    }

    /**
     * 根据数组顺序创建链表
     * @param array - int[]
     * @return LinkNode
     */
    public static LinkNode createLink(int[] array) {
        LinkNode temp = new LinkNode(array[0]);
        LinkNode root = temp;
        for(int i=1;i<array.length;i++) {
            LinkNode node = new LinkNode(array[i]);
            temp.next = node;
            node.pre = temp;
            temp = node;
        }

        return root;
    }

    /**
     * 打印链表数据
     * @param root - LinkNode
     */
    public static void printOrderLink(LinkNode root) {
        if(root == null) {
            System.out.println("[]");
            return;
        }
        LinkNode temp = root;
        while(temp != null) {
            System.out.print(temp.data+",");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 根据数组顺序创建链表
     * @param array - int[]
     * @return ListNode
     */
    public static ListNode createListLink(int[] array) {
        ListNode temp = new ListNode(array[0]);
        ListNode root = temp;
        for(int i=1;i<array.length;i++) {
            ListNode node = new ListNode(array[i]);
            temp.next = node;
            temp = node;
        }

        return root;
    }



    /**
     * 根据数组顺序创建链表
     * @param array      int[]
     * @param cycleIndex 循环指向的索引值，-1则不是环形
     * @return ListNode
     */
    public static ListNode createCycleListLink(int[] array, int cycleIndex) {
        ListNode temp = new ListNode(array[0]);
        ListNode root = temp;
        ListNode cycleNode = null;
        for(int i=1;i<array.length;i++) {
            ListNode node = new ListNode(array[i]);
            temp.next = node;
            temp = node;

            if(i == cycleIndex) {
                cycleNode = node;
            }
        }

        if(cycleIndex == 0) {
            temp.next = root;
        } else if(cycleIndex > 0) {
            temp.next = cycleNode;
        }

        return root;
    }

    /**
     * 打印链表数据
     * @param root - ListNode
     */
    public static void printListLink(ListNode root) {
        if(root == null) {
            System.out.println("[]");
            return;
        }
        ListNode temp = root;
        while(temp != null) {
            System.out.print(temp.val+",");
            temp = temp.next;
        }
        System.out.println();
    }

    private Tools() {}

}
