package com.inuker.solution;

import com.leetcode.library.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by dingjikerbo on 2016/11/17.
 */

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                next.add(node.left);
            }

            if (node.right != null) {
                next.add(node.right);
            }

            if (queue.isEmpty()) {
                result.add(node.val);
                Queue<TreeNode> temp = queue;
                queue = next;
                next = temp;
            }
        }

        return result;
    }
}
