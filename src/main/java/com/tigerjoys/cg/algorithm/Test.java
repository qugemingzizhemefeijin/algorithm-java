package com.tigerjoys.cg.algorithm;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        String s1 = new String(new char[]{'d', 'e'}, 0, 2);
        s1.intern();
        System.out.println(s1 == "de");

        //System.out.println(reverse(102));
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
