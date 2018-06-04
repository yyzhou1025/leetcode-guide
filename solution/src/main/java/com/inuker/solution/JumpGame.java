package com.inuker.solution;

/**
 * Created by dingjikerbo on 17/5/11.
 */

public class JumpGame {

    public boolean canJump(int[] nums) {
        int i = 0;

        for (int reach = 0; i < nums.length && i <= reach; i++) {
            reach = Math.max(reach, i + nums[i]);
        }

        return i == nums.length;
    }
}
