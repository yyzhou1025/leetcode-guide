package com.inuker.solution;

import com.leetcode.library.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/12/1.
 */

public class BinaryTreePostorderTraversal {

    /**
     * 先序是中左右，中序是左中右，后序是左右中，所以我们可以给先序调整一下改成中右左，然后倒过来就成了左右中
     * @param root
     * @return
     */
    // 这里虽然最后的结果返回的是对的，但真正访问节点的顺序是不对的，root并不是最后访问的
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                results.add(0, root.val);
                root = root.right;
            } else {
                root = stack.pop().left;
            }
        }
        return results;
    }
}
