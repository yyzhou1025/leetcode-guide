package com.leetcode.amazon;

/**
 * Created by liwentian on 17/8/12.
 */

public class CountPrimes {

    public int countPrimes(int n) {
        boolean[] f = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!f[i]) {
                count++;
                for (int j = 2; j * i < n; j++) {
                    f[i * j] = true;
                }
            }
        }
        return count;
    }
}
