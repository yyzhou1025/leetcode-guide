package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/12/7.
 */

public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int sum;
        for (sum = 0; n > 0; n /= 5, sum += n);
        return sum;
    }
}
