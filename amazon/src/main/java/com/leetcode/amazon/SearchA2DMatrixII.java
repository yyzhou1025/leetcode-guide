package com.leetcode.amazon;

/**
 * Created by liwentian on 17/8/11.
 */

public class SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        for (int i = 0, j = matrix[0].length - 1; j >= 0 && i < matrix.length; ) {
            if (target < matrix[i][j]) {
                j--;
            } else if (target > matrix[i][j]) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
