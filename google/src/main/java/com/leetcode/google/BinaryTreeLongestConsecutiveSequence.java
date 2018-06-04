package com.leetcode.google;

import com.leetcode.library.TreeNode;

/**
 * Created by liwentian on 17/8/26.
 */

public class BinaryTreeLongestConsecutiveSequence {

    private int mMaxLen;

    public int longestConsecutive(TreeNode root) {
        helper(root, 1);
        return mMaxLen;
    }

    private void helper(TreeNode node, int len) {
        if (node == null) {
            return;
        }

        mMaxLen = Math.max(len, mMaxLen);

        if (node.left != null) {
            helper(node.left, 1 + (node.left.val == node.val + 1 ? len : 0));
        }

        if (node.right != null) {
            helper(node.right, 1 + (node.right.val == node.val + 1 ? len : 0));
        }
    }
}
