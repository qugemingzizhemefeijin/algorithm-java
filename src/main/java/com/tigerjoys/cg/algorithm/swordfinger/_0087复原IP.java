package com.tigerjoys.cg.algorithm.swordfinger;

import com.tigerjoys.cg.algorithm.utils.Tools;

import java.util.ArrayList;
import java.util.List;

/**
 * 难度：中等
 * 题目：
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 *
 * 输入：s = "10203040"
 * 输出：["10.20.30.40","102.0.30.40","10.203.0.40"]
 *
 */
public class _0087复原IP {

    public static void main(String[] args) {
        String s = "10203040";
        Tools.printJson(restoreIpAddresses(s));
    }

    // 把给定的字符串分成四段，我们需要三个隔板，枚举三个隔板所有可能的位置就行，注意本题其实 s的长度不能大于12，大于12的话肯定有一段大于255，所以可以通过
    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        //大于12的时候直接返回
        if (s == null || s.length() < 4 || s.length() > 12) {
            return list;
        }
        int len = s.length();
        for(int i=1;i<len-2;i++) {
            for(int j=i+1;j<len-1;j++) {
                for(int k=j+1;k<len;k++) {
                    // 判断字符是否满足IP
                    if(check(s, i, j, k)) {
                        list.add(s.substring(0, i) + "." + s.substring(i, j) + "." + s.substring(j, k) + "." + s.substring(k));
                    }
                }
            }
        }
        return list;
    }

    private static boolean check(String s, int i, int j, int k) {
        String s0 = s.substring(0, i);
        if(s0.charAt(0) == '0' && s0.length() > 1 || Integer.parseInt(s0) > 255) {
            return false;
        }

        String s1 = s.substring(i, j);
        if(s1.charAt(0) == '0' && s1.length() > 1 || Integer.parseInt(s1) > 255) {
            return false;
        }

        String s2 = s.substring(j, k);
        if(s2.charAt(0) == '0' && s2.length() > 1 || Integer.parseInt(s2) > 255) {
            return false;
        }

        String s3 = s.substring(k);
        if(s3.charAt(0) == '0' && s3.length() > 1 || Integer.parseInt(s3) > 255) {
            return false;
        }

        return true;
    }

}
