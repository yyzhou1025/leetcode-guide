package com.leetcode.amazon;

import java.util.Arrays;

/**
 * Created by liwentian on 17/8/14.
 */

public class ValidSudoku {

    private boolean check(char c, boolean[] f) {
        if (c == '.') {
            return true;
        }
        if (f[c - '1']) {
            return false;
        }
        f[c - '1'] = true;
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[] f = new boolean[9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(f, false);
            for (int j = 0; j < 9; j++) {
                if (!check(board[i][j], f)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            Arrays.fill(f, false);
            for (int j = 0; j < 9; j++) {
                if (!check(board[j][i], f)) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(f, false);
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        int x = i * 3 + m, y = j * 3 + n;
                        if (!check(board[x][y], f)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
