package com.leetcode.facebook;

/**
 * Created by liwentian on 17/8/17.
 */

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 1, right = n;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    boolean isBadVersion(int version) {
        return false;
    }
}
