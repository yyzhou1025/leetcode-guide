package com.leetcode.facebook;

/**
 * Created by liwentian on 17/8/18.
 */

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        for (int i = 0, j = s.length() - 1; i < j; ) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } else if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}
