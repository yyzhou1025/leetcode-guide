package com.leetcode.google;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 2017/8/29.
 */

public class MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new LinkedList<>();

        long cur = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > cur) {
                list.add(get(cur, nums[i] - 1));
                cur = (long) nums[i] + 1;
            } else if (nums[i] == cur) {
                cur++;
            }
        }

        if (cur <= upper) {
            list.add(get(cur, upper));
        }

        return list;
    }

    private String get(long cur, long end) {
        if (end > cur) {
            return cur + "->" + end;
        } else {
            return cur + "";
        }
    }
}
