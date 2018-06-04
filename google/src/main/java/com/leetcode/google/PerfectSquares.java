package com.leetcode.google;

/**
 * Created by liwentian on 2017/8/31.
 */

public class PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; i - j * j >= 0; j++) {
                min = Math.min(dp[i - j * j] + 1, min);
            }
            dp[i] = min;
        }

        return dp[n];

    }
}
