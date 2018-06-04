package com.leetcode.facebook;

/**
 * Created by liwentian on 17/8/18.
 */

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        } else if (p.length() == 1) {
            return s.length() == 1 && isEquals(s, p);
        } else if (p.charAt(1) != '*') {
            return s.length() > 0 && isEquals(s, p) && isMatch(s.substring(1), p.substring(1));
        } else {
            if (s.length() > 0 && isEquals(s, p)) {
                return isMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
            } else {
                return isMatch(s, p.substring(2));
            }
        }
    }

    private boolean isEquals(String s, String p) {
        return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
    }
}
