package com.inuker.solution;

import com.leetcode.library.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 2016/12/17.
 */

public class ExcelSheetColumnNumber {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        dfs(root, list, "" + root.val);
        return list;
    }

    private void dfs(TreeNode root, List<String> list, String s) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(s);
            return;
        }
        if (root.left != null) {
            dfs(root.left, list, s + "->" + root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, list, s + "->" + root.right.val);
        }
    }
}
