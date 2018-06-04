package com.leetcode.amazon;

/**
 * Created by liwentian on 17/8/5.
 */

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j; ) {
            int s = numbers[i] + numbers[j];
            if (s > target) {
                j--;
            } else if (s < target) {
                i++;
            } else {
                return new int[] {i + 1, j + 1};
            }
        }
        return null;
    }
}
