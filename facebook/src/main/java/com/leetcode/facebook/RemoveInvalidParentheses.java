package com.leetcode.facebook;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 17/8/17.
 */

public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<>();

        int nL = 0, nR = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                nL++;
            } else if (c == ')') {
                if (nL > 0) {
                    nL--;
                } else {
                    nR++;
                }
            }
        }

        dfs(s, "", set, 0, nL, nR, 0);
        return new LinkedList<>(set);
    }

    private void dfs(String s, String t, HashSet<String> set, int i, int nL, int nR, int count) {
        if (nL < 0 || nR < 0 || count < 0) {
            return;
        }
        if (i == s.length()) {
            if (nL == 0 && nR == 0 && count == 0) {
                set.add(t);
            }
            return;
        }
        char c = s.charAt(i);
        if (c == '(') {
            dfs(s, t, set, i + 1, nL - 1, nR, count);
            dfs(s, t + "(", set, i + 1, nL, nR, count + 1);
        } else if (c == ')') {
            dfs(s, t, set, i + 1, nL, nR - 1, count);
            dfs(s, t + ")", set, i + 1, nL, nR, count - 1);
        } else {
            dfs(s, t + c, set, i + 1, nL, nR, count);
        }
    }
}
