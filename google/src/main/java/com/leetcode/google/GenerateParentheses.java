package com.leetcode.google;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 2017/9/3.
 */

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<String>();
        dfs(result, n, "", 0, 0);
        return result;
    }

    private void dfs(List<String> result, int n, String str, int left, int right) {
        if (left == n && right == n) {
            result.add(str);
            return;
        }
        if (left > n || right > n || left < right) {
            return;
        }
        dfs(result, n, str + "(", left + 1, right);
        dfs(result, n, str + ")", left, right + 1);
    }
}
