package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/19.
 */

/**
 * https://leetcode.com/articles/move-zeroes/
 */
public class MoveZeroes {

    /**
     * 要保持顺序，写的次数最少
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                swap(nums, i++, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    /**
     * 如果不要求保持顺序，且写的次数最少
     */
    public void moveZeroes2(int[] nums) {
        for (int i = 0, j = nums.length - 1; j > i; ) {
            if (nums[i] != 0) {
                i++;
            } else if (nums[j] != 0) {
                swap(nums, i, j--);
            } else {
                j--;
            }
        }
    }
}
