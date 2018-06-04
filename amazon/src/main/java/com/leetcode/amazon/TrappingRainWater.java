package com.leetcode.amazon;

/**
 * Created by liwentian on 17/8/11.
 */

public class TrappingRainWater {

    public int trap(int[] height) {
        int len = height.length;

        if (len == 0) {
            return 0;
        }

        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = 0;
        right[len - 1] = 0;

        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i>= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int high = Math.min(left[i], right[i]);
            if (high > height[i]) {
                sum += high - height[i];
            }
        }
        return sum;
    }
}
