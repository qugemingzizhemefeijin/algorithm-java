package com.tigerjoys.cg.algorithm.interview.moka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListImplMinHeap {


    public static class MinHeap<E extends Comparable<E>> {
        private final List<E> data;
        public MinHeap(int capacity) {
            data = new ArrayList<>(capacity);
        }
        public MinHeap() {
            data = new ArrayList<>();
        }
        private int parent(int index) {
            if (index == 0)
                throw new IllegalArgumentException("dont have parent");
            return (index - 1) / 2;
        }
        private int leftChild(int index) {
            return index * 2 + 1;
        }
        private int rightChild(int index) {
            return index * 2 + 2;
        }
        public void add(E e) {
            data.add(e);//向数组最后添加元素，arraylist本身add就是添加到最后
            siftUp(data.size() - 1);//传入想上浮元素的索引
        }
        private void siftUp(int k) {
            while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) > 0) {//k比k的父亲节点小
                Collections.swap(data, k, parent(k));
                k = parent(k);//下一轮再看这个父亲节点的是否需要上浮，是否满足堆的性质
                //k等于0到达树顶或者满足性质停止上浮
            }
        }
        public E extraMin() {
            E ret = data.get(0);
            Collections.swap(data, 0, size() - 1);//交换最大和最小元素
            data.remove(size() - 1);//取出堆尾，即最小元素
            siftDown(0);//将堆顶最小元素下沉，保证堆的性质
            return ret;
        }
        private void siftDown(int k) {
            while (leftChild(k) < data.size()) {//左孩子没有越界有左孩子节点
                int j = leftChild(k);
                if (j + 1 < data.size()
                        && data.get(j + 1).compareTo(data.get(j)) < 0) {
                    j++;
                    //此时data[j]为左右孩子中小的那个
                }
                if (data.get(k).compareTo(data.get(j)) < 0)//已经满足性质
                    break;
                Collections.swap(data, k, j);
                k = j;//进行下一轮循环，判断
            }
        }
        public int size() {
            return data.size();
        }
        public String toString() {
            return data.toString();
        }
    }

    // ArrayList实现最小堆
    public static void main(String[] args) {
        MinHeap<Integer> min = new MinHeap<>();
        min.add(10);
        System.out.println(min);
        min.add(20);
        System.out.println(min);
        min.add(8);
        System.out.println(min);
        min.add(6);
        System.out.println(min);
        min.add(11);
        System.out.println(min);

        System.out.println(min.extraMin());
        System.out.println(min.extraMin());
        System.out.println(min.extraMin());
        System.out.println(min.extraMin());
        System.out.println(min.extraMin());
    }

}
