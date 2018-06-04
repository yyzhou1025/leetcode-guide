package com.inuker.solution;

import com.leetcode.library.TreeNode;

/**
 * Created by dingjikerbo on 2016/11/29.
 */

public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        sum -= root.val;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
