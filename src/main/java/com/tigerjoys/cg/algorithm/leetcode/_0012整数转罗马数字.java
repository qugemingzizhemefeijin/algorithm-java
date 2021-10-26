package com.tigerjoys.cg.algorithm.leetcode;

/**
 *
 * 难度：中等
 *
 * 题目：罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 *
 * 输入: num = 3
 * 输出: "III"
 *
 * 输入: num = 9
 * 输出: "IX"
 *
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 *
 */
public class _0012整数转罗马数字 {

    public static void main(String[] args) {
        System.out.println(intToRoman1(58));
        System.out.println(intToRoman2(58));
    }

    // 方法二：硬编码数字
    // 千位数字只能由 M 表示；
    // 百位数字只能由 C，CD，D 和 CM 表示；
    // 十位数字只能由 X，XL，L 和 XC 表示；
    // 个位数字只能由 I，IV，V 和 IX 表示
    public static String intToRoman2(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[num / 1000] +
                hundreds[num % 1000 / 100] +
                tens[num % 100 / 10] +
                ones[num % 10];
    }

    // 方法一：模拟
    // 根据罗马数字的唯一表示法，为了表示一个给定的整数 num，我们寻找不超过 num 的最大符号值，将 }num 减去该符号值，
    // 然后继续寻找不超过 num 的最大符号值，将该符号拼接在上一个找到的符号之后，循环直至 num 为 0。最后得到的字符串即为 num 的罗马数字表示。
    public static String intToRoman1(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int v = values[i];
            String symbol = symbols[i];
            while(num >= v) {
                roman.append(symbol);
                num -= v;
            }
            if(num == 0) {
                break;
            }
        }

        return roman.toString();
    }

}
