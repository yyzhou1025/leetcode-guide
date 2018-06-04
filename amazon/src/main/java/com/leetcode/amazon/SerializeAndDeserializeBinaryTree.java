package com.leetcode.amazon;

import com.leetcode.library.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dingjikerbo on 2017/8/7.
 */

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "x";
        }
        String s = String.valueOf(root.val) + ",";
        s += serialize(root.left) + ",";
        s += serialize(root.right);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] texts = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(texts));
        return helper(queue);
    }

    private TreeNode helper(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String s = queue.poll();
        if (s.equals("x")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}
