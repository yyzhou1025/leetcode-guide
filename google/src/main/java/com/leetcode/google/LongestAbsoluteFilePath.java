package com.leetcode.google;

import java.util.Stack;

/**
 * Created by liwentian on 17/8/22.
 */

public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<Integer>();
        String[] lines = input.split("\n");

        int max = 0;
        for (String line : lines) {
            int level = line.lastIndexOf('\t') + 1;

            while (stack.size() > level) {
                stack.pop();
            }

            int parent = stack.isEmpty() ? 0 : stack.peek();

            int len = parent + line.length() - level + 1;

            stack.push(len);

            if (line.contains(".")) {
                max = Math.max(max, len - 1);
            }
        }

        return max;
    }
}
