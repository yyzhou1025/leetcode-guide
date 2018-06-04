package com.inuker.solution;

import com.leetcode.library.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/12/3.
 */

public class PathSumIII {

    /**
     * 当root.val == Sum时，不要return，因为继续往下走可能有路径刚好加起来为0，典型的为[1,-2,1,-1]，目标和为-1
     * 这里隐藏了四条路径，[1,-2], [-2,1], [-1], [1,-2,1,-1]，如果在[1,-2]就return了，那就会掉了[1,-2,1,-1]
     * 可参考https://discuss.leetcode.com/category/562/path-sum-iii
     */

    /**
     * 有两种可能，算上当前root和不算当前root
     */
    public int pathSum(TreeNode root, int sum) {
        int[] count = new int[1];
        helperSum(root, sum, count);
        return count[0];
    }

    /**
     * 既可以算上，也可以不算上root
     */
    private void helperSum(TreeNode root, int sum, int[] count) {
        if (root == null) {
            return;
        }

        // 算上root
        helper(root, sum, count);

        // 不算上root
        helperSum(root.left, sum, count);
        helperSum(root.right, sum, count);
    }

    /**
     * 算上root
     */
    private void helper(TreeNode root, int sum, int[] count) {
        if (root == null) {
            return;
        }
        if (root.val == sum) {
            count[0]++;
            // 这里不用返回，因为下面的路径和可能为0;
        }

        helper(root.left, sum - root.val, count);
        helper(root.right, sum - root.val, count);
    }

    /* 如果要给路径打出来
    public List<String> pathSum(TreeNode root, int sum) {
        List<String> result = new LinkedList<>();
        pathSum(root, sum, result, "");
        return result;
    }

    private void pathSum(TreeNode root, int sum, List<String> list, String path) {
        if (root == null) {
            return;
        }

        pathSumWithRoot(root, sum, list, path);

        pathSum(root.left, sum, list, "");
        pathSum(root.right, sum, list, "");
    }

    private void pathSumWithRoot(TreeNode root, int sum, List<String> list, String path) {
        if (root == null) {
            return;
        }

        String prefix = path.isEmpty() ? "" : path + "->";

        if (root.val == sum) {
            list.add(prefix + root.val);
        }
        pathSumWithRoot(root.left, sum - root.val, list, prefix + root.val);
        pathSumWithRoot(root.right, sum - root.val, list, prefix + root.val);
    }*/
}
