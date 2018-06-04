package com.leetcode.amazon;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by liwentian on 17/8/10.
 */

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });

        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = map.firstKey();

        for (int i = 1; i < result.length; i++) {
            int count = map.getOrDefault(nums[i - 1], 0);
            if (count <= 1) {
                map.remove(nums[i - 1]);
            } else {
                map.put(nums[i - 1], count - 1);
            }
            map.put(nums[i + k - 1], map.getOrDefault(nums[i + k - 1], 0) + 1);
            result[i] = map.firstKey();
        }

        return result;
    }
}
