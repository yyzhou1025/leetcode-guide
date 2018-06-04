package com.inuker.solution;

import com.leetcode.library.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dingjikerbo on 16/11/30.
 */

public class FlattenBinaryTreeToLinkedList {

    /**
     * 非递归，先序遍历一遍，再串起来
     */
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack();

        List<TreeNode> list = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                list.add(root);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
    }

    public void flatten2(TreeNode root) {
        helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = root.right;
        TreeNode leftTail = null, rightTail = null;

        if (root.left != null) {
            leftTail = helper(root.left);
            root.right = root.left;
            root.left = null;
            leftTail.right = right;
        }

        rightTail = helper(right);

        return rightTail != null ? rightTail : leftTail;
    }
}
