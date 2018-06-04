package com.inuker.solution;

import com.leetcode.library.TreeNode;

/**
 * Created by dingjikerbo on 16/12/1.
 */

public class CountUnivalueSubtrees {

    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }

    boolean helper(TreeNode root, int[] count) {
        if (root == null) {
            return true;
        }

        boolean left = helper(root.left, count);
        boolean right = helper(root.right, count);

        if (left && right) {
            if (root.left != null && root.left.val != root.val) {
                return false;
            }
            if (root.right != null && root.right.val != root.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
}
