package com.inuker.solution;

/**
 * Created by liwentian on 17/8/14.
 */

public class ReverseWordsInAString {


    // 耗时10ms
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        boolean inWord = false;
        char[] cc = s.toCharArray();
        for (int i = cc.length - 1, idx = 0; i >= 0; i--) {
            if (cc[i] != ' ') {
                if (!inWord && sb.length() > 0) {
                    sb.append(' ');
                }
                inWord = true;
                sb.insert(idx, cc[i]);
            } else if (inWord) {
                idx = sb.length() + 1;
                inWord = false;
            }
        }

        return sb.toString();
    }

    // 耗时18ms
    public String reverseWords2(String s) {
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
