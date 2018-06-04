package com.leetcode.google;

/**
 * Created by liwentian on 17/8/24.
 */

public class RangeSumQuery2DImmutable {

    private int[][] dp;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }
}
