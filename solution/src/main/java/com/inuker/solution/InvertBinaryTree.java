package com.inuker.solution;

import com.leetcode.library.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dingjikerbo on 16/11/28.
 */

/**
 * 给非递归法也要会写
 */
public class InvertBinaryTree {

    /** 错误的写法，写顺手了
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.right = invertTree(root.left);
        root.left = invertTree(root.right);
        return root;
    }*/

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode right = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(right);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return root;
    }
}
