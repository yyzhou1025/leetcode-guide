package com.inuker.solution;

import com.leetcode.library.TreeNode;

/**
 * Created by dingjikerbo on 16/11/28.
 */

public class MinimumDepthOfBinaryTree {

    /**
     * 错误的写法，和第104题非常类似
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }*/

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 如果一边空了，那这边深度为0，但是由于不是叶子节点，所以不能算，得看另一边。
        if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    /**
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(helper(root.left), helper(root.right)) + 1;
    }*/
}
