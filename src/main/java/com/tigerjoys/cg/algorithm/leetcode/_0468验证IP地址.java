package com.tigerjoys.cg.algorithm.leetcode;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.regex.Pattern;

/**
 * 难度：中等
 * 题目：
 *
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。
 *
 * 如果是有效的 IPv4 地址，返回 "IPv4" ；
 * 如果是有效的 IPv6 地址，返回 "IPv6" ；
 * 如果不是上述类型的 IP 地址，返回 "Neither" 。
 * IPv4 地址由十进制数和点来表示，每个地址包含 4 个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
 *
 * 同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
 *
 * IPv6 地址由 8 组 16 进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
 *
 * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 *
 * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
 *
 * 输入：IP = "172.16.254.1"
 * 输出："IPv4"
 * 解释：有效的 IPv4 地址，返回 "IPv4"
 *
 * 输入：IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * 输出："IPv6"
 * 解释：有效的 IPv6 地址，返回 "IPv6"
 *
 * 输入：IP = "256.256.256.256"
 * 输出："Neither"
 * 解释：既不是 IPv4 地址，又不是 IPv6 地址
 *
 * 输入：IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:"
 * 输出："Neither"
 *
 * 输入：IP = "1e1.4.5.6"
 * 输出："Neither"
 *
 */
public class _0468验证IP地址 {

    public static void main(String[] args) {
        System.out.println(validIPAddress2("172.16.254.1"));
        System.out.println(validIPAddress3("172.16.254.1"));
    }

    // 正则
    public static String validIPAddress3(String IP) {
        String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        Pattern patternIPV4 = Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

        String chunkIPv6 = "([0-9a-fA-F]{1,4})";
        Pattern pattenIPv6 = Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

        if(IP.contains(".")) {
            return patternIPV4.matcher(IP).matches() ? "IPv4" : "Neither";
        } else if(IP.contains(":")) {
            return pattenIPv6.matcher(IP).matches() ? "IPv6" : "Neither";
        }
        return "Neither";
    }

    // 内置函数和 try/catch 结构检查 IP 地址的正确性
    public static String validIPAddress2(String IP) {
        try {
            return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6": "IPv4";
        } catch(Exception ignored) {}
        return "Neither";
    }

    // 我自己的写法
    public static String validIPAddress1(String IP) {
        if(IP == null || IP.length() < 7) {
            return "Neither";
        }
        String[] strs;
        if(IP.indexOf(":") > 0) {
            strs = IP.split(":");
            if(strs.length != 8) {
                return "Neither1";
            }
        } else {
            strs = IP.split("\\.");
            if(strs.length != 4) {
                return "Neither2";
            }
        }

        // IPV4
        if(strs.length == 4) {
            for(String s : strs) {
                if(s.length() == 0 || s.length() > 3 || s.charAt(0) == '0') {
                    return "Neither3";
                }
                // 验证是否都是数字
                for(char c : s.toCharArray()) {
                    if(c < '0' || c > '9') {
                        return "Neither4";
                    }
                }
                if(Integer.parseInt(s) > 255) {
                    return "Neither5";
                }
            }
            return "IPv4";
        } else {
            for(String s : strs) {
                if(s.length() != 4) {
                    return "Neither";
                }
                // 验证是否都是数字
                for(char c : s.toCharArray()) {
                    if((c < '0' || c > '9') && (c < 'A' || c > 'F') && (c < 'a' || c > 'f')) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
    }

}
