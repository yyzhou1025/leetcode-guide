package com.leetcode.amazon;

import com.leetcode.library.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by liwentian on 17/8/14.
 */

public class BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<TreeNode, Integer> valueMap = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        addNode(root, map, valueMap, 0);

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            int val = valueMap.get(node);

            if (node.left != null) {
                queue.offer(node.left);
                addNode(node.left, map, valueMap, val - 1);
            }

            if (node.right != null) {
                queue.offer(node.right);
                addNode(node.right, map, valueMap, val + 1);
            }

            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }

        return result;
    }

    private void addNode(TreeNode node, HashMap<Integer, List<Integer>> map, HashMap<TreeNode, Integer> values, int level) {
        List<Integer> list = map.get(level);
        if (list == null) {
            list = new LinkedList<>();
            map.put(level, list);
        }
        list.add(node.val);
        values.put(node, level);
    }

}
