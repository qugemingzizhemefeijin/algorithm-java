package com.tigerjoys.cg.algorithm.utils;

import lombok.Data;

@Data
public class LinkNode {

    public int data;
    public LinkNode pre;
    public LinkNode next;

    public LinkNode() {

    }

    public LinkNode(int data) {
        this.data = data;
    }

    public LinkNode(int data, LinkNode pre, LinkNode next) {
        this.data = data;
        this.pre = pre;
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkNode [data=" + data + ", pre=" + (pre != null ? pre.data : null) + ", next=" + (next != null ? next.data : null) + "]";
    }

}
