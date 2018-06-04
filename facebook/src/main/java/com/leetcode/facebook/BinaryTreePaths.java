package com.leetcode.facebook;

import com.leetcode.library.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 17/8/18.
 */

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        helper(root, list, "");
        return list;
    }

    private void helper(TreeNode root, List<String> list, String s) {
        if (root == null) {
            return;
        }

        s += (s.isEmpty() ? "" : "->") + root.val;

        if (root.left == null && root.right == null) {
            list.add(s);
            return;
        }

        helper(root.left, list, s);
        helper(root.right, list, s);
    }
}
