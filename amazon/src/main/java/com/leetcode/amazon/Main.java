package com.leetcode.amazon;

import com.leetcode.library.TreeNode;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by liwentian on 2017/10/16.
 */

public class Main {

    public class LargestBSTSubtree {

        class Result {
            int count;
            int lower;
            int upper;

            Result(int count, int lower, int upper) {
                this.count = count;
                this.lower = lower;
                this.upper = upper;
            }
        }

        public int largestBSTSubtree(TreeNode root) {
            Result res = helper(root);
            return Math.abs(res.count);
        }

        private Result helper(TreeNode root) {
            if (root == null) {
                return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
            }

            Result left = helper(root.left);
            Result right = helper(root.right);

            // 注意这里的等号千万别掉了，因为可能树中有节点相同
            if (left.count < 0 || right.count < 0 || left.upper >= root.val || right.lower <= root.val) {
                return new Result(-1 * Math.max(Math.abs(left.count), Math.abs(right.count)), 0, 0);
            }

            return new Result(left.count + right.count + 1, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
        }
    }

    public static void main(String[] args) {

    }
}
