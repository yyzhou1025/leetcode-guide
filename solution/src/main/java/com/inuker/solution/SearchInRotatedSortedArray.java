package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/23.
 */

public class SearchInRotatedSortedArray {
    /**
     * TestCase
     * [1, 2], 1/2/3
     * [2, 1], 2/1/3
     * [1], 1/2
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == nums[mid]) {
                return mid;
            }

            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
