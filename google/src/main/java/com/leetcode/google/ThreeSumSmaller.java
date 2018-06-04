package com.leetcode.google;

import java.util.Arrays;

/**
 * Created by liwentian on 2017/8/30.
 */

public class ThreeSumSmaller {
    // -4 -1 -1 0 1 2 ,target=-5
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);

        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    count += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }

        return count;
    }
}
