package com.inuker.solution;

import com.leetcode.library.TreeNode;

/**
 * Created by dingjikerbo on 16/11/28.
 */

public class MaximumDepthOfBinaryTree {

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
}
