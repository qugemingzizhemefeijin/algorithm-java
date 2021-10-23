package com.tigerjoys.cg.algorithm.utils;

import lombok.Data;

/**
 * 单链表对象
 * @param <T>
 */
@Data
public class SingleNode<T> {

    public final T val;

    public SingleNode<T> next;

    public SingleNode(T val) {
        this.val = val;
    }

    public SingleNode(T val, SingleNode<T> next) {
        this.val = val;
        this.next = next;
    }

}
