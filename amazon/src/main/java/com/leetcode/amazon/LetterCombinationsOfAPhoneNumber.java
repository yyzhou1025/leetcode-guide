package com.leetcode.amazon;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 17/8/10.
 */

public class LetterCombinationsOfAPhoneNumber {

    private final String[] ARR = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

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
}
