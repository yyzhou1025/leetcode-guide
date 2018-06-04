package com.inuker.solution;

/**
 * Created by liwentian on 2016/12/29.
 */

public class CountNumberWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        for (int i = 1, t = 9; i <= n; i++) {
            result[i] = result[i - 1] + t;
            t *= 10 - i;
        }
        return result[n];
    }
}
