package com.inuker.solution;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

public class LetterCombinationOfPhoneNumber {

    /**
     * leetcode的测试用例中不包括包含"0"或"1"的情况
     */

    private final String[] ARR = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    // 耗时3ms
    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if (!digits.isEmpty()) {
            helper(digits, 0, list, "");
        }
        return list;
    }

    private void helper(String digits, int start, List<String> list, String s) {
        if (start >= digits.length()) {
            list.add(s);
            return;
        }
        int n = digits.charAt(start) - '0';
        for (char c : ARR[n].toCharArray()) {
            helper(digits, start + 1, list, s + c);
        }
    }

    /**
     * 非递归法，BFS,耗时5ms
     */
    public List<String> letterCombinations2(String digits) {
        LinkedList<String> queue = new LinkedList<String>();
        if (digits.length() == 0) {
            return queue;
        }

        Queue<String> next = new LinkedList<>();
        queue.add("");

        for (int i = 0; i < digits.length() && !queue.isEmpty(); ) {
            String s = queue.poll();
            int n = digits.charAt(i) - '0';
            for (char c : ARR[n].toCharArray()) {
                next.add(s + c);
            }
            if (queue.isEmpty()) {
                queue.addAll(next);
                next.clear();
                i++;
            }
        }
        return queue;
    }
}
