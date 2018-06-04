package com.leetcode.amazon;

import java.util.HashMap;

/**
 * Created by liwentian on 17/8/5.
 */

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null && index != i) {
                return new int[] {
                        i, index
                };
            }
        }
        return null;
    }
}
