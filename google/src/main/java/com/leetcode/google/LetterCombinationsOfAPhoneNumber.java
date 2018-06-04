package com.leetcode.google;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 2017/9/3.
 */

public class LetterCombinationsOfAPhoneNumber {

    final String[] NUMS = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits.isEmpty()) {
            return result;
        }
        dfs(digits, result, 0, "");
        return result;
    }

    private void dfs(String digits, List<String> result, int idx, String cur) {
        if (idx == digits.length()) {
            result.add(cur);
            return;
        }

        int n = digits.charAt(idx) - '0';
        for (char c : NUMS[n].toCharArray()) {
            dfs(digits, result, idx + 1, cur + c);
        }
    }
}
