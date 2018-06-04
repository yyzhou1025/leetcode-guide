package com.inuker.solution;

import com.leetcode.library.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/12/3.
 */

public class FindLeavesOfBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        helper(root, result);
        return result;
    }

    private int helper(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return -1;
        }
        int level = Math.max(helper(root.left, result), helper(root.right, result)) + 1;
        if (result.size() <= level) {
            result.add(new LinkedList<Integer>());
        }
        result.get(level).add(root.val);
        return level;
    }
}
