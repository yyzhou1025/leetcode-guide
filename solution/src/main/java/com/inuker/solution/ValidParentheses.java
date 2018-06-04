package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

/**
 * 要注意栈判空
 */
public class ValidParentheses {

    // 耗时5ms
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        for (char c : s.toCharArray()) {
            switch (c) {
                case ')':
                    if (top >= 0 && stack[top] == '(') {
                        top--;
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (top >= 0 && stack[top] == '{') {
                        top--;
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (top >= 0 && stack[top] == '[') {
                        top--;
                    } else {
                        return false;
                    }
                    break;
                default:
                    stack[++top] = c;
                    break;
            }
        }

        return top < 0;
    }
}
