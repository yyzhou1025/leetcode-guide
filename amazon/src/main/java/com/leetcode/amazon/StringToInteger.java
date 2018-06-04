package com.leetcode.amazon;

/**
 * Created by liwentian on 17/8/12.
 */

public class StringToInteger {

    // 非法字符
    // 前后空格
    // 空字符
    // 正负号
    // 溢出
    public int myAtoi(String str) {
        str = str.trim();

        if (str.isEmpty()) {
            return 0;
        }

        int sign = 1;
        long result = 0;

        int i = 0;

        char c = str.charAt(0);
        if (c == '+' || c == '-') {
            sign = c == '-' ? -1 : 1;
            i++;
        }

        for (; i < str.length(); i++) {
            c = str.charAt(i);

            if (c >= '0' && c <= '9') {
                result = result * 10 + (c - '0');

                if (result * sign > Integer.MAX_VALUE || result * sign < Integer.MIN_VALUE) {
                    break;
                }
            } else {
                break;
            }
        }

        result *= sign;

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }
}
