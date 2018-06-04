package com.leetcode.amazon;

/**
 * Created by liwentian on 17/8/14.
 */

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0, j = 0; i < s.length(); ) {
            if (s.charAt(i) == ' ') {
                i++;
                j = i;
            } else if (j >= s.length() || s.charAt(j) == ' ') {
                sb.insert(0, s.substring(i, j) + " ");
                i = j;
            } else {
                j++;
            }
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }
}
