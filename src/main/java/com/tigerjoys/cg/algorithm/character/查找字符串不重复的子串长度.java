package com.tigerjoys.cg.algorithm.character;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;

public class 查找字符串不重复的子串长度 {

    public static void main(String[] args) {
        String s = "bbbb";

        System.out.println(resolveThree(s));
    }

    private static int resolveThree(String s) {
        int len = s.length();
        if(len == 0) {
            return len;
        }

        int ret = 0;
        Map<Character, Integer> map = Maps.newHashMap();
        for (int i = 0, j = 0; j < len; j++) {
            Character c = s.charAt(j);
            if(map.containsKey(c)) {
                i = map.get(c);
            }
            ret = Math.max(ret, j - i + 1);
            map.put(c, j + 1);
        }
        return ret;
    }

    private static int resolveTwo(String s) {
        int len = s.length();
        if(len == 0) {
            return len;
        }

        Set<Character> sv = Sets.newHashSet();
        int ret = 0, i = 0, j = 0;
        while(i < len && j < len) {
            if(!sv.contains(s.charAt(j))) {
                sv.add(s.charAt(j++));
                ret = Math.max(ret, j - i);
            } else {
                sv.remove(s.charAt(i++));
            }
        }
        return ret;
    }

    // 暴力解法
    private static int resolveOne(String s) {
        int len = s.length();
        if(len == 0) {
            return len;
        }
        int ret = 0;
        for(int i=0;i<len;i++) {
            for(int j=i+1;j<=len;j++) {
                if(uniqChar(s, i, j)) ret = Math.max(ret, j - i);
            }
        }

        return ret;
    }

    private static boolean uniqChar(String s, int i, int j) {
        Set<Character> sv = Sets.newHashSet();
        for(int x=i;x<j;x++) {
            if(!sv.add(s.charAt(x))) {
                return false;
            }
        }
        return true;
    }

}
