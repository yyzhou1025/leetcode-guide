package com.leetcode.google;

/**
 * Created by liwentian on 17/8/23.
 */

public class RangeSumQueryMutable {

    private SegmentTreeNode mRoot;

    public RangeSumQueryMutable(int[] nums) {
        mRoot = buildTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode();
        root.start = start;
        root.end = end;

        if (start == end) {
            root.sum = nums[start];
            return root;
        }

        int mid = start + ((end - start) >> 1);
        root.left = buildTree(nums, start, mid);
        root.right = buildTree(nums, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    public void update(int i, int val) {
        update(mRoot, i, val);
    }

    private void update(SegmentTreeNode node, int i, int val) {
        int start = node.start, end = node.end;
        if (start == end) {
            node.sum = val;
            return;
        }

        int mid = start + ((end - start) >> 1);
        if (i <= mid) {
            update(node.left, i, val);
        } else {
            update(node.right, i, val);
        }
        node.sum = node.left.sum + node.right.sum;
    }

    public int sumRange(int i, int j) {
        return sumRange(mRoot, i, j);
    }

    private int sumRange(SegmentTreeNode node, int i, int j) {
        int start = node.start, end = node.end;
        if (i == start && j == end) {
            return node.sum;
        }
        int mid = start + ((end - start) >> 1);
        if (j <= mid) {
            return sumRange(node.left, i, j);
        } else if (i > mid) {
            return sumRange(node.right, i, j);
        } else {
            return sumRange(node.left, i, mid) + sumRange(node.right, mid + 1, j);
        }
    }

    private class SegmentTreeNode {
        SegmentTreeNode left, right;

        int sum;

        int start, end;
    }
}
