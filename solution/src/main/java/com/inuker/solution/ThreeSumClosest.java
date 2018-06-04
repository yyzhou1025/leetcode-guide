package com.inuker.solution;

import java.util.Arrays;

/**
 * Created by dingjikerbo on 17/5/5.
 */

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        long dis = Integer.MAX_VALUE, result = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int newTarget = target - nums[i];

            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int sum = nums[j] + nums[k];

                if (sum > newTarget) {
                    k--;
                } else if (sum < newTarget) {
                    j++;
                } else {
                    return target;
                }

                long delta = Math.abs(newTarget - sum);
                if (delta < dis) {
                    dis = delta;
                    result = sum + nums[i];
                }
            }
        }

        return (int) result;
    }
}
