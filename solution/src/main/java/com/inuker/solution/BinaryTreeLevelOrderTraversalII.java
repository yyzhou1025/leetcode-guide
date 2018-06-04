package com.inuker.solution;

import com.leetcode.library.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by dingjikerbo on 2016/11/17.
 */

public class BinaryTreeLevelOrderTraversalII {

    // 耗时2ms，和I一样，只不过加到result时添加到头
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        queue.add(root);

        List<Integer> cur = null;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (cur == null) {
                cur = new LinkedList<Integer>();
                result.add(0, cur);
            }

            cur.add(node.val);

            if (node.left != null) {
                next.add(node.left);
            }

            if (node.right != null) {
                next.add(node.right);
            }

            if (queue.isEmpty()) {
                Queue<TreeNode> temp = queue;
                queue = next;
                next = temp;
                cur = null; // 注意这里要置空
            }
        }

        return result;
    }
}
