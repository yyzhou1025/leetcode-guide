package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/12/15.
 */

public class MaximumSubarray {

    // dp[i]表示包含第i个元素时的最大和
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
            if (i > 0 && dp[i - 1] > 0) {
                dp[i] += dp[i - 1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int max = Integer.MIN_VALUE, prev = 0;
        for (int i = 0; i < nums.length; i++) {
            prev = Math.max(nums[i], nums[i] + prev);
            max = Math.max(max, prev);
        }
        return max;
    }
}
