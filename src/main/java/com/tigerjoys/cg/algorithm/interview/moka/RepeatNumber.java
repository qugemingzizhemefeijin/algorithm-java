package com.tigerjoys.cg.algorithm.interview.moka;

import java.util.*;

public class RepeatNumber {

    // 1.查看数组的重复数，要求按照顺序输出
    // 2.按照出现重复的频率正序排列
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 1, 3, 5, 6, 5, 7, 6, 1};
        norepeat1(a);
        norepeat2(a);
        repeat1(a);
    }

    // 问不重复的是哪几个数字
    private static void norepeat1(int[] a) {
        Set<Integer> s = new HashSet<>();
        Set<Integer> v = new HashSet<>();
        for(int i : a) {
            if (s.contains(i)) {
                v.remove(i);
            } else {
                s.add(i);
                v.add(i);
            }
        }

        System.out.println(v);
    }

    private static void norepeat2(int[] a) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int i : a) {
            m.merge(i, 1, Integer::sum);
        }

        for(Map.Entry<Integer, Integer> me : m.entrySet()) {
            if (me.getValue() == 1) {
                System.out.print(me.getKey()+",");
            }
        }
        System.out.println();
    }

    private static void repeat1(int[] a) {
        Map<Integer, Integer> m = new TreeMap<>();
        for(int i: a) {
            m.merge(i, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> me : m.entrySet()) {
            if (me.getValue() > 1) {
                System.out.print(me.getKey() + ",");
            }
        }
        System.out.println();
    }

}
