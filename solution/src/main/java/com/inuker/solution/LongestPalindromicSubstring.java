package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

/**
 * 这题采用动态规划也可，但是不论时间还是空间性能都不好
 */
public class LongestPalindromicSubstring {

    private int begin, maxLen;

    // 耗时14ms，平均复杂度O(n)
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return s.substring(begin, begin + maxLen);
    }

    private void helper(String s, int i, int j) {
        for (; i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j); i--, j++) ;
        int len = j - i - 1;
        if (len > maxLen) {
            maxLen = len;
            begin = i + 1;
        }
    }

    // 动态规划，耗时73ms，复杂度O(n^2)
    public String longestPalindrome2(String s) {
        int len = s.length();

        if (len == 0) {
            return s;
        }

        boolean[][] f = new boolean[len][len];

        int index = 0;
        int max = 1;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j < 2 || f[j + 1][i - 1])) {
                    f[j][i] = true;

                    if (i - j + 1 > max) {
                        max = i - j + 1;
                        index = j;
                    }
                }
            }
        }

        return s.substring(index, index + max);
    }
}
