package com.leetcode.google;

import com.leetcode.library.TreeNode;

import java.util.Stack;

/**
 * Created by liwentian on 2017/11/29.
 */

public class RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null, first = null, second = null;

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();

                if (prev != null) {
                    if (first == null && prev.val > root.val) {
                        first = prev;
                    }
                    if (first != null && prev.val > root.val) {
                        second = root;
                    }
                }
                prev = root;
                root = root.right;
            }
        }

        int t = first.val;
        first.val = second.val;
        second.val = t;
    }
}
