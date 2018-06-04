package com.leetcode.amazon;

import com.leetcode.library.TreeNode;

/**
 * Created by liwentian on 17/8/11.
 */

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);
    }

    private boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        return root.val > lower && root.val < upper
                && isValidBST(root.left, lower, root.val)
                && isValidBST(root.right, root.val, upper);
    }
}
