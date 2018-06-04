package com.leetcode.amazon;

import com.leetcode.library.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liwentian on 17/8/12.
 */

public class SerializeAndDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X";
        }

        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
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
        if (s.equals("X")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}
