package com.tigerjoys.cg.algorithm.interview.moka;

import java.util.Stack;

public class TwoStackQueue {

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();

        put(s1, s2, 10);
        put(s1, s2, 9);
        put(s1, s2, 8);
        put(s1, s2, 7);

        System.out.println(take(s1, s2));
        System.out.println(take(s1, s2));
        System.out.println(take(s1, s2));
        System.out.println(take(s1, s2));
    }

    public static int take(Stack<Integer> s1, Stack<Integer> s2) {
        while(!s2.isEmpty()) {
            s1.add(s2.pop());
        }

        return s1.pop();
    }

    public static void put(Stack<Integer> s1, Stack<Integer> s2, int i) {
        s2.add(i);
    }

}
