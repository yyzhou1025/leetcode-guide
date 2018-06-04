package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/12/10.
 */

public class UglyNumber {

    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        for ( ; num % 2 == 0; num /= 2);
        for ( ; num % 3 == 0; num /= 3);
        for ( ; num % 5 == 0; num /= 5);
        return num == 1;
    }
}
