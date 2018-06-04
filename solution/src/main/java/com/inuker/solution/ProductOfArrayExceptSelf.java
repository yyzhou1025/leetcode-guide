package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

public class ProductOfArrayExceptSelf {

    // 耗时2ms
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
}
