package com.tigerjoys.cg.algorithm;

public class Test {

    public static void main(String[] args) {
        System.out.println(reverse(102));
    }

    private static int reverse(int x) {
        int ret = 0;
        while(x > 0) {
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        return ret;
    }

}
