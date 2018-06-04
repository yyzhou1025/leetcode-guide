package com.leetcode.google;

/**
 * Created by liwentian on 2017/9/3.
 */

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        if (p.length() == 1) {
            return s.length() == 1 && equals(s, p);
        }
        if (p.charAt(1) != '*') {
            return s.length() > 0 && equals(s, p) && isMatch(s.substring(1), p.substring(1));
        }
        if (s.isEmpty() || !equals(s, p)) {
            return isMatch(s, p.substring(2));
        } else {
            return isMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
        }
    }

    private boolean equals(String s, String p) {
        return p.charAt(0) == '.' || s.charAt(0) == p.charAt(0);
    }
}
