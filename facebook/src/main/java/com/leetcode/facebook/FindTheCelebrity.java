package com.leetcode.facebook;

/**
 * Created by liwentian on 17/8/17.
 */

public class FindTheCelebrity {

    public int findCelebrity(int n) {
        int id = 0;
        for (int i = 1; i < n; i++) {
            if (knows(id, i)) {
                id = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == id) {
                continue;
            }
            if (knows(id, i) || !knows(i, id)) {
                return -1;
            }
        }
        return id;
    }

    boolean knows(int a, int b) {
        return false;
    }
}
