package com.leetcode.google;

/**
 * Created by liwentian on 2017/8/30.
 */

public class WiggleSort {

    public void wiggleSort(int[] nums) {
        for (int i = 0; i + 1 < nums.length; i++) {
            if ((i & 1) == 0) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
