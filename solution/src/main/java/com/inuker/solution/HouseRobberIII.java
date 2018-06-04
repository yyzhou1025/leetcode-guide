package com.inuker.solution;

import com.leetcode.library.TreeNode;

/**
 * Created by dingjikerbo on 16/12/1.
 */

public class HouseRobberIII {

    public int rob(TreeNode root) {
        return rob(root, true);
    }

    /**
     * @param rob true表示不定，false表示不选root
     */
    private int rob(TreeNode root, boolean rob) {
        if (root == null) {
            return 0;
        }

        if (rob) {
            return Math.max(root.val + rob(root.left, false) + rob(root.right, false),
                    rob(root.left, true) + rob(root.right, true));
        } else {
            return rob(root.left, true) + rob(root.right, true);
        }
    }
}
