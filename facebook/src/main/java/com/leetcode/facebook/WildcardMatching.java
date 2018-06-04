package com.leetcode.facebook;

/**
 * Created by liwentian on 17/8/18.
 */

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        int is = 0, ip = 0, ks = -1, kp = -1;

        while (is < s.length()) {
            if (ip < p.length() && (s.charAt(is) == p.charAt(ip) || p.charAt(ip) == '?')) {
                is++;
                ip++;
            } else if (ip < p.length() && p.charAt(ip) == '*') {
                ks = is;
                kp = ip++;
            } else if (ks != -1) {
                is = ++ks;
                ip = kp + 1;
            } else {
                return false;
            }
        }

        for ( ; ip < p.length() && p.charAt(ip) == '*'; ip++);

        return ip == p.length();
    }
}
