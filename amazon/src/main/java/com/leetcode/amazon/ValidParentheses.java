package com.leetcode.amazon;

/**
 * Created by liwentian on 17/8/9.
 */

public class ValidParentheses {

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
