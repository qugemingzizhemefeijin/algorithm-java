package com.tigerjoys.cg.algorithm.sort;

/**
 * 数组工具类
 *
 * @author chengang
 * @create 2018-04-13 15:33
 */
public class ArrayUtils {

    public static final int[] SQLIST = { 23, 0, 12, 56, 34 , 85 , 47, 37, 9 ,6, 2 };

    //交换计数
    private static int SAWP_COUNTER = 0;

    //循环计数
    private static int CRILY_COUNTER = 0;
    
    /**
     * 设置指定索引的值
     */
    public static void set(int i, int val) {
    	SQLIST[i] = val;
    }
    
    /**
     * 获取指定索引的值
     * @return int
     */
    public static int get(int i) {
    	return SQLIST[i];
    }
    
    /**
     * 判断i索引值是否大于j索引值
     * @return boolean
     */
    public static boolean gt(int i, int j) {
    	return SQLIST[i] > SQLIST[j];
    }
    
    /**
     * 判断i索引值是否小于j索引值
     * @return boolean
     */
    public static boolean lt(int i, int j) {
    	return SQLIST[i] < SQLIST[j];
    }
    
    /**
     * 返回数组的长度
     * @return int
     */
    public static int length() {
    	return SQLIST.length;
    }

    /**
     * 交换数组指定位置的元素
     * @param i - 位置1
     * @param j - 位置2
     */
    public static void swap(int i , int j) {
        int temp = SQLIST[i];
        SQLIST[i] = SQLIST[j];
        SQLIST[j] = temp;

        SAWP_COUNTER++;
    }

    /**
     * 交换数组指定位置的元素
     * @param i - 位置1
     * @param j - 位置2
     */
    public static void swap(int[] array, int i , int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 循环计数
     */
    public static void cryleCounter(){
        CRILY_COUNTER++;
    }
    
    /**
     * 交换次数+1
     */
    public static void swapCounter() {
    	SAWP_COUNTER++;
    }

    /**
     * 打印数组内容
     */
    public static void print(){
        for(int i=0;i<SQLIST.length;i++) {
            if(i>0) {
                System.out.print(" , ");
            }
            System.out.print(SQLIST[i]);
        }
        System.out.println();
        System.out.println("总交换次数：" + SAWP_COUNTER);
        System.out.println("总循环次数：" + CRILY_COUNTER);
    }

    public static void print(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            if(i>0) {
                System.out.print(" , ");
            }
            System.out.print(arr[i]);
        }
        System.out.println();
    }
    
    public static class Node {
    	public Object data;
    	public Node next;
    	public Node() {
    		
    	}
    	public Node(Object data) {
    		this.data = data;
    	}
    	public Node(Object data, Node next) {
    		this.data = data;
    		this.next = next;
    	}
    }
    
    /**
     * 初始化指定数量的节点
     * @param num - 数量
     * @return Node 头
     */
    public static Node initNode(int num) {
    	Node head = null, last = null;
    	for(int i=0;i<num;i++) {
    		Node node = new Node(i, last);
    		if(i == 0) {
    			head = node;
    		}
    		last = node;
    	}
    	return head;
    }
    
    /**
     * 初始化有环的链表
     * @param num - 数量
     * @param lastPoint - 指定最后一个节点指向第几个节点
     * @return Node 头
     */
    public static Node initLinkNode(int num, int lastPoint) {
    	Node head = null, last = null, point = null;
    	for(int i=0;i<num;i++) {
    		Node node = new Node(i);
    		if(i == 0) {
    			head = node;
    		}
    		if(i == lastPoint - 1) {
    			point = node;
    		}
    		if(i == num - 1) {
    			node.next = point;
    		}
    		if(last != null) {
    			last.next = node;
    		}
    		last = node;
    	}
    	return head;
    }

    private ArrayUtils(){

    }

}
