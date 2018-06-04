package com.leetcode.amazon;

/**
 * Created by liwentian on 17/8/10.
 */

/**
 * h
 */
public class LongestPalindromicSubstring {

    private int maxLen, begin;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return s.substring(begin, begin + maxLen);
    }

    private void helper(String s, int i, int j) {
        for ( ; i >= 0 && j < s.length() &&  s.charAt(i) == s.charAt(j); i--, j++);
        int len = j - i - 1;
        if (len > maxLen) {
            maxLen = len;
            begin = i + 1;
        }
    }


}
