package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/12/17.
 */

/**
 * https://leetcode.com/articles/next-permutation/
 */
public class NextPermutation {

    /**
     * 思路是从右往左找到升序转降序的转折点nums[i]
     * 然后从升序中找到一个大于nums[i-1]的最小数与i-1交换，然后对升序整体revert为降序即可
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;

        for ( ; i >= 0; i--) {
            if (i > 0 && nums[i - 1] < nums[i]) {
                break;
            }
        }

        if (i < 0) {
            revert(nums, 0, nums.length - 1);
            return;
        }

        for (int j = nums.length - 1; j >= i; j--) {
            if (nums[j] > nums[i - 1]) {
                swap(nums, j, i - 1);
                revert(nums, i, nums.length - 1);
                break;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private void revert(int[] nums, int start, int end) {
        for ( ; start < end; start++, end--) {
            swap(nums, start, end);
        }
    }
}
