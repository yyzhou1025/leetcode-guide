package com.inuker.solution;

import java.util.Arrays;

/**
 * Created by dingjikerbo on 17/1/5.
 */

public class LongestIncreasingSubsequence {

    /**
     * 这题是典型的DP，f[i]包含i的最长子序列长度
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] f = new int[n];
        /**
         * 注意这里fill是有必要的
         */
        Arrays.fill(f, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            max = Math.max(max, f[i]);
        }
        return max;
    }

    public int lengthOfLIS2(int[] nums) {
        int len = 1;
        for (int i = 0; i < nums.length; i++) {
            /**
             * 注意这里要指定区间，且end是开区间
             */
            int k = Arrays.binarySearch(nums, 0, len, nums[i]);
            /**
             * 只处理k<0的情况
             */
            if (k < 0) {
                k = -(k + 1);
                if (k == len) {
                    len++;
                }
                nums[k] = nums[i];
            }
        }
        return len;
    }
}
