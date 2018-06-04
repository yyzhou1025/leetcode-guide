package com.leetcode.facebook;

/**
 * Created by liwentian on 17/8/18.
 */

public class SortColors {

    public void sortColors(int[] nums) {
        int zero = -1, two = nums.length;
        for (int i = 0; i < two; ) {
            if (nums[i] == 0) {
                swap(nums, ++zero, i);
            } else if (nums[i] == 2) {
                swap(nums, --two, i);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
