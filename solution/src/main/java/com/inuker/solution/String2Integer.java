package com.inuker.solution;

/**
 * Created by dingjikerbo on 17/4/29.
 */

/**
 * 要求如下：
 * 1. 过滤掉前面的空格
 * 2. 考虑正负号
 * 3. 如果溢出则返回上限或下限
 * 4. 解析时遇到非法字符则停止，返回当前结果
 * 5，防御空串
 */

/**
 * TestCase: ""
 */
public class String2Integer {

    public int myAtoi(String str) {
        long n = 0;

        str = str.trim();

        // 这里要防御空串
        if (str.length() == 0) {
            return 0;
        }

        int sign = 1;

        switch (str.charAt(0)) {
            case '-':
                sign = -1;
            case '+':
                str = str.substring(1);
                break;
        }

        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') {
                n = n * 10 + (c - '0');

                if (n * sign > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (n * sign < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }

            } else {
                break;
            }
        }

        return (int) (n * sign);
    }
}
