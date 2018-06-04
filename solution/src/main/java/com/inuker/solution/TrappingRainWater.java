package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

/**
 * 核心思路就是对于每根柱子，找到其左边最高的柱子和右边最高的柱子，构成一个桶，形成一个水平面，然后对该柱子形成的高度差就是能装的水
 */
public class TrappingRainWater {

    // 耗时24ms
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
