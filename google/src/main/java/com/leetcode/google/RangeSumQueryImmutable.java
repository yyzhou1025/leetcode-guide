package com.leetcode.google;

/**
 * Created by liwentian on 17/8/23.
 */

public class RangeSumQueryImmutable {

    private int[] sums;

    public RangeSumQueryImmutable(int[] nums) {
        sums = new int[nums.length];
        for (int sum = 0, i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        int sum1 = i > 0 ? sums[i - 1] : 0;
        return sums[j] - sum1;
    }
}
