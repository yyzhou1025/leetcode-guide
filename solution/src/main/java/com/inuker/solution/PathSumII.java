package com.inuker.solution;

import com.leetcode.library.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 2016/11/29.
 */

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        pathSum(root, sum, result, new LinkedList<Integer>());
        return result;
    }

    /**
     * 这里一定要拷贝一份链表再加到result
     * 此时path中已经包含了root，sum中还不包含root
     */
    private void pathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList<>(list));
            return;
        }

        if (root.left != null) {
            pathSum(root.left, sum - root.val, result, list);
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            pathSum(root.right, sum - root.val, result, list);
            list.remove(list.size() - 1);
        }
    }
}
