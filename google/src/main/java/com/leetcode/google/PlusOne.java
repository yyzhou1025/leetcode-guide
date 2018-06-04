package com.leetcode.google;

/**
 * Created by liwentian on 2017/8/30.
 */

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length + 1];

        int flag = 1;
        for (int i = digits.length - 1; i >= 0 || flag > 0; i--) {
            int s = flag + (i >= 0 ? digits[i] : 0);
            res[i + 1] = s % 10;
            flag = s / 10;
        }

        if (res[0] != 0) {
            return res;
        }

        int[] ret = new int[digits.length];
        System.arraycopy(res, 1, ret, 0, ret.length);
        return ret;
    }
}
