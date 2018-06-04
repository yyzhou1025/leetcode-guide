package com.inuker.solution;

import com.leetcode.library.TreeNode;

/**
 * Created by dingjikerbo on 17/1/2.
 */

public class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }

            root.val = node.val;
            root.right = deleteNode(root.right, node.val);
        }

        return root;
    }
}
