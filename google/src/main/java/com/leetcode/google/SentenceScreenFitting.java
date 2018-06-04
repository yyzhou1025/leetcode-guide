package com.leetcode.google;

/**
 * Created by liwentian on 17/8/26.
 */

public class SentenceScreenFitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";

        int start = 0, len = s.length();

        for (int i = 0; i < rows; i++) {
            start += cols;

            if (s.charAt(start % len) == ' ') {
                start++;
            } else {
                for ( ; start > 0 && s.charAt((start - 1) % len) != ' '; start--);
            }
        }

        return start / len;
    }
}
