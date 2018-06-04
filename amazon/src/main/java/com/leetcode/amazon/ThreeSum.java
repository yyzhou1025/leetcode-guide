package com.leetcode.amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 17/8/11.
 */

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    for (j++, k--; j < k && nums[j] == nums[j - 1]; j++);
                }
            }
        }


        return result;
    }

}
