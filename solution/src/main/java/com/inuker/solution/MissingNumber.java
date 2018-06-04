package com.inuker.solution;

/**
 * Created by liwentian on 2017/9/10.
 */

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor;
    }
}
