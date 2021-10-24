package com.tigerjoys.cg.algorithm.leetcode;

import com.google.common.collect.Lists;

import java.util.List;

/**
 *
 * 难度：medium
 *
 * 题目：将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 解释：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 * 思路：
 *
 */
public class _0006Z字形变换 {

    public static void main(String[] args) {
        System.out.println(convert1("PAYPALISHIRING", 4));
    }

    // 我们可以使用 min(numRows,len(s)) 个列表来表示 Z 字形图案中的非空行。
    // 从左到右迭代 s，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
    // 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。（就是箭头发生改变）
    public static String convert1(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        int len = s.length();
        List<StringBuffer> rows = Lists.newArrayListWithCapacity(numRows);
        for (int i = 0; i < Math.min(numRows, len); i++) {
            rows.add(new StringBuffer());
        }

        boolean goingDown = false;
        int curRow = 0;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuffer ret = new StringBuffer();
        for(StringBuffer buf : rows) {
            ret.append(buf.toString());
        }
        return ret.toString();
    }

}
