package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/12/20.
 */

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}
