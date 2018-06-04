package com.leetcode.facebook;

import java.util.Arrays;

/**
 * Created by liwentian on 17/8/17.
 */

public class DecodeWays {

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] f = new int[s.length()];
        Arrays.fill(f, -1);
        return helper(s.toCharArray(), f, 0);
    }

    private int helper(char[] s, int[] f, int i) {
        if (i >= s.length) {
            return 1;
        }

        if (s[i] == '0') {
            return 0;
        }

        if (f[i] >= 0) {
            return f[i];
        }

        int sum = helper(s, f, i + 1);

        if (i + 1 < s.length && (s[i] == '1' || (s[i] == '2' && s[i + 1] <= '6'))) {
            sum += helper(s, f, i + 2);
        }

        f[i] = sum;

        return sum;
    }
}
