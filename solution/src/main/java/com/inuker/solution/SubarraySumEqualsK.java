package com.inuker.solution;

import java.util.HashMap;

/**
 * Created by liwentian on 2017/12/5.
 * https://leetcode.com/articles/subarray-sum-equals-k/
 */

public class SubarraySumEqualsK {

    /**
     * 注意map.put(0,1)，即当前数自己也算是一种
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
