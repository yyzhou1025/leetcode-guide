package com.leetcode.facebook;

import com.leetcode.library.TreeNode;

/**
 * Created by liwentian on 17/8/18.
 */

public class InorderSuccessorInBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode node = null;
        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else if (p.val < root.val) {
                node = root;
                root = root.left;
            }
        }
        return node;
    }
}
