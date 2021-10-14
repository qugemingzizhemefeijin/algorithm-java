package com.tigerjoys.cg.algorithm.sort;

// 基排序原理就是通过个位数的排序，然后再十位数的排序，即可达到整体排序的效果
public class 基数排序 {

    static class Node {
        int v;
        Node next;

        public Node(int v) {
            this.v = v;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11, 23, 54, 2, 0, 800, 20};
        //首先便宜一遍，看看最大值是几位
        int maxBit = maxBit(arr);
        for(int i=0;i<maxBit;i++) {
            arr = sort(arr, i);
        }
        ArrayUtils.print(arr);
    }

    private static int maxBit(int[] arr) {
        int m = 0;
        for (int v : arr) {
            m = Math.max(String.valueOf(v).length(), m);
        }
        return m;
    }

    private static int[] sort(int[] arr, int bit) {
        Node[] n = new Node[10];
        for (int v : arr) {
            int temp = v;
            if (bit > 0) {
                temp = temp / ((int) Math.pow(10, bit));
            }
            // 计算temp存放的索引项中
            int index = temp % 10;
            Node c = n[index];
            if (c != null) {
                while (c.next != null) {
                    c = c.next;
                }
                c.next = new Node(v);
            } else {
                n[index] = new Node(v);
            }
        }

        // 计算完毕后，遍历Node，并返回数组
        return eachNode(n, arr.length);
    }

    private static int[] eachNode(Node[] n, int size) {
        int[] arr = new int[size];
        int i = 0;
        for(Node c : n) {
            if(c == null) {
                continue;
            }
            for(;c != null;c=c.next) {
                arr[i++] = c.v;
            }
        }
        return arr;
    }

}
