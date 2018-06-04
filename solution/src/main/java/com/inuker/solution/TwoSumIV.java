package com.inuker.solution;

import com.leetcode.library.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by liwentian on 2017/9/10.
 */

/**
 * https://leetcode.com/articles/two-sum-iv/
 */
public class TwoSumIV {

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        for (int i = 0, j = nums.size() - 1; i < j; ) {
            if (nums.get(i) + nums.get(j) == k) return true;
            if (nums.get(i) + nums.get(j) < k) i++;
            else j--;
        }
        return false;
    }

    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}
