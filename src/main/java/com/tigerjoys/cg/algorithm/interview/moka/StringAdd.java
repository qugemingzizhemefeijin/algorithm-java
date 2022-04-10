package com.tigerjoys.cg.algorithm.interview.moka;

public class StringAdd {

    // 输入两个字符串，进行相加，不能转int
    public static void main(String[] args) {
        String s1 = "123", s2 = "4567";

        // 先对端的补0，变成一样长，然后进行相加
        int len1 = s1.length(), len2 = s2.length();
        String small = len1 > len2 ? s2 : s1;
        String large = len1 < len2 ? s2 : s1;

        StringBuilder b = new StringBuilder();
        for(int i=0;i<Math.abs(len1 - len2);i++) {
            b.append(0);
        }

        small = b.toString() + small;

        StringBuilder sb = new StringBuilder();
        int jw = 0;
        int len = small.length();
        for (int i = 0; i < len; i++) {
            char c1 = small.charAt(len - 1 - i);
            char c2 = large.charAt(len - 1 - i);
            int sum = c1 + c2 - 96 + jw;
            if (sum >= 10) {
                sb.append(sum % 10);
                jw = 1;
            } else {
                sb.append(sum);
                jw = 0;
            }
        }

        if (jw == 0) {
            System.out.println(sb.reverse().toString());
        } else {
            System.out.println(sb.append(1).reverse().toString());
        }
    }

}
