package com.inuker.solution;

import com.leetcode.library.TreeNode;

import java.util.Stack;

/**
 * Created by dingjikerbo on 16/11/30.
 */

/**
 * 这题关键是follow up
 * 如果更新频繁，则通常的做法每次都是O(n)，更优的做法是O(lgn)
 * 即给node中记录左子树的节点个数，这样在找kth smallest时流程如下：
 * 假设root的左子树节点有N个，则
 * 1， 当K=N+1时，kth就是root
 * 2,  当K<N+1时，kth就到左子树中找
 * 3， 当K>N+1时，就到右子树中找第K-N-1个
 * 所以当给定一棵树时，我们要先重建一下这棵树，统计一下各节点的左子树节点数，虽然首次是O(n）
 * 但是之后就是O(h)了。
 */
public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
        int[] kth = new int[1];
        inorderTraversal(root, k, kth);
        return kth[0];
    }

    private int inorderTraversal(TreeNode root, int k, int[] kth) {
        if (root == null) {
            return k;
        }

        k = inorderTraversal(root.left, k, kth);

        if (--k == 0) {
            kth[0] = root.val;
            return 0;
        }

        return inorderTraversal(root.right, k, kth);
    }

    /**
     * 非递归法
     */
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();

                if (--k == 0) {
                    return root.val;
                }

                root = root.right;
            }
        }
        throw new IllegalStateException();
    }

    /**
     * Morris
     */
    private int kthSmallest3(TreeNode root, int k) {
        TreeNode temp;

        while (root != null) {
            if (root.left == null) {
                if (--k == 0) {
                    return root.val;
                }
                root = root.right;
            } else {
                temp = root.left;
                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                } else {
                    temp.right = null;
                    if (--k == 0) {
                        return root.val;
                    }
                    root = root.right;
                }
            }
        }
        throw new IllegalStateException();
    }
}
