package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/24.
 */

public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (j < 1 || nums[i] != nums[j - 1]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
