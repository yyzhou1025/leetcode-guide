package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/12/17.
 */

public class SearchForARange {

    /**
     * TestCase
     * [1], 0
     * [1], 1
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int first = firstHigherEqual(nums, target);
        if (first == nums.length || nums[first] != target) {
            return new int[] {
                    -1, -1
            };
        }
        return new int[] {
                first,
                firstHigherEqual(nums, target + 1) - 1
        };
    }

    private int firstHigherEqual(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int[] searchRange2(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[] {
                lowerBound(nums, target),
                upperBound(nums, target)
        };
    }

    /**
     * lowerBound和upperBound的TestCase
     * [1,3],3
     * [1,3],1
     * [2,2],2
     */
    public static int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1);

            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left] == target ? left : -1;
    }

    public static int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1) + 1;

            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return nums[right] == target ? right : -1;
    }
}
