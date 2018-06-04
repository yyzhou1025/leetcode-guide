package com.inuker.solution;

import com.leetcode.library.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/12/1.
 */

/**
 * Dp的解法可以参考https://discuss.leetcode.com/topic/2940/java-solution-with-dp
 */
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return Collections.EMPTY_LIST;
        }
        return generateTrees(1, n);
    }

    // 从start到end之间取一个数作为root，左边构成left，右边构成right
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new LinkedList<TreeNode>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTrees(start, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }

            }
        }
        return list;
    }
}
