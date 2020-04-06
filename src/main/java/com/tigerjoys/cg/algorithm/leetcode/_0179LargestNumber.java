package com.tigerjoys.cg.algorithm.leetcode;

import java.util.Arrays;

/**
 * 
 * 难度：medium
 * 题目：给定非负整数数组，重组其序使其形成最大值。
 * 思路：定制排序算法的比较策略，nums[i]拼接nums[j] 与 nums[j]拼接nums[i] 相比。
 *
 */
public class _0179LargestNumber {
	
	public static void main(String[] args) {
		int[] i = new int[] {10,80,2,9};
		System.err.println(largestNumber(i));
		System.err.println(myAtoi(" -0k4"));
	}
	
	public static int myAtoi(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();

        boolean b = false;
        StringBuilder buf = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(i==0 && c == '-'){
                buf.append(c);
                b = true;
            } else if(c >= 48 && c <= 57) {
                buf.append(c);
            } else if(c == '+' && !b){
                continue;
            } else {
                break;
            }
        }

        String s = buf.toString();
        s = s.replaceAll("^0*", "");
        s = s.replaceAll("^[-]0*", "-");
       
        if(s.length() == 0 || (b && s.length() == 1)){
            return 0;
        }
        String v = null;
        if(b){
            v = String.valueOf(Integer.MIN_VALUE);
        } else {
            v = String.valueOf(Integer.MAX_VALUE);
        }

        if(s.length() < v.length() || (s.length() == v.length() && s.compareTo(v) <= 0)){
            return Integer.parseInt(s);
        } else {
            if(b){
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }
	
	public static String largestNumber(int[] nums) {
		if(nums == null || nums.length == 0) {
			return "0";
		}
		if(nums.length == 1) {
			return String.valueOf(nums[0]);
		}
		
		String[] ss = new String[nums.length];
		for(int i=0;i<ss.length;i++) {
			ss[i] = String.valueOf(nums[i]);
		}
		
		/*Arrays.sort(ss, (s1,s2)->{
			String s1s2 = s1 + s2;
			String s2s1 = s2 + s1;
			return s2s1.compareTo(s1s2);
		});*/
		
		Arrays.sort(ss, (s1,s2)->{
			return s2.compareTo(s1);
		});
		
		StringBuilder buf = new StringBuilder();
		for(int i=0;i<ss.length;i++) {
			buf.append(ss[i]);
		}
		
		return buf.toString();
	}

}
