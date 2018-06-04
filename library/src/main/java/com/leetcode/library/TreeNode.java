package com.leetcode.library;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }

//    public static TreeNode buildTree(Integer... array) {
//        Integer[] s = new Integer[array.length];
//        for (int i = 0; i < array.length; i++) {
//            s[i] = array[i];
//        }
//        return buildTree(s);
//    }

    /**
     * 建立完全二叉树
     */
    public static TreeNode buildTree(Integer[] array) {
        TreeNode[] nodes = new TreeNode[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            nodes[i] = array[i] == null ? null : new TreeNode(array[i]);

            if (2 * i + 1 < array.length) {
                nodes[i].left = nodes[2 * i + 1];
            }

            if (2 * i + 2 < array.length) {
                nodes[i].right = nodes[2 * i + 2];
            }
        }

        return nodes[0];
    }
}
