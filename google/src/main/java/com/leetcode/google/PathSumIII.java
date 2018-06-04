package com.leetcode.google;

import com.leetcode.library.TreeNode;

/**
 * Created by liwentian on 2017/11/29.
 */

public class PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        int[] count = new int[1];
        helperSum(root, sum, count);
        return count[0];
    }

    private void helperSum(TreeNode root, int sum, int[] count) {
        if (root == null) {
            return;
        }
        helper(root, sum, count);
        helperSum(root.left, sum, count);
        helperSum(root.right, sum, count);
    }

    private void helper(TreeNode root, int sum, int[] count) {
        if (root == null) {
            return;
        }
        if (root.val == sum) {
            count[0]++;
        }
        helper(root.left, sum - root.val, count);
        helper(root.right, sum - root.val, count);
    }
}
