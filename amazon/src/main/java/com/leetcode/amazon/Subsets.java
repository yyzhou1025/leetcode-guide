package com.leetcode.amazon;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 17/8/12.
 */

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        helper(nums, result, new LinkedList<Integer>(), 0);
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, LinkedList<Integer> list, int index) {
        if (index == nums.length) {
            result.add(new LinkedList<>(list));
            return;
        }

        list.add(nums[index]);
        helper(nums, result, list, index + 1);
        list.remove(list.size() - 1);

        helper(nums, result, list, index + 1);
    }
}
