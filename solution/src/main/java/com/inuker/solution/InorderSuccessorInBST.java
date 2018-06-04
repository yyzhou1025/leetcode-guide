package com.inuker.solution;

import com.leetcode.library.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dingjikerbo on 16/11/20.
 */

/**
 * 有两种方法，用栈做普通的中序遍历，这种没有充分利用BST的特点
 * 第二种方法比较巧妙，首先遍历到p，然后继续遍历找到p的右子树的最小值
 */
public class InorderSuccessorInBST {

    // 耗时10ms
    // 时间复杂度O(n)
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = null, prev = null;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (prev == p) {
                    return node;
                }
                prev = node;
                node = node.right;
            }
        }
        return null;
    }

    /**
     * p的下一个节点一定是比p大的，所以这里遍历时当p的值小于当前节点，则当前节点
     * 可作为备选，同时往左走。如果在遍历过程中遇到仍然比p大的，说明更接近p，则更新备选。
     *
     * 有两点要注意，
     * 1， 首先res初始要为null，一个节点时，或root为null时，或p为最大节点时，res都没机会赋值
     * 2， 当root迭代到等于p时，走哪个分支呢，为什么选root = root.right，假如root.right为空，则之前的res即可，否则
     * 下一个迭代肯定走到root.val > p.val分支中，更新res。
     */
    // 耗时4ms
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }

    /**
     * http://www.geeksforgeeks.org/?p=9999
     * 给定Node，求其successor，步骤如下：
     * 1， 如果Node.right != null，则在Node.right中找最小的那个节点，即从Node.right开始，最左下角的节点
     * 2， 如果Node.right == null，则不断往parent走，直到当前节点是其parent的左节点为止，其parent即为给定Node的successor
    private TreeNode inOrderSuccessor(TreeNode root, TreeNode node) {
        if (node.right != null) {
            return minValue(node.right);
        }

        TreeNode parent = node.parent;
        while (parent != null && node == parent.right) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

     private TreeNode minValue(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }*/

    /**
     * 这题如果改成给定一个节点，求出其之后的所有successor或predesessor
     * 以下可用于 #272. Closest Binary Search Tree Value II
     */
    public List<TreeNode> getAllSuccessor(TreeNode root, int target) {
        Stack<TreeNode> stack = new Stack<>();
        buildSuccessorStack(root, stack, target);
        List<TreeNode> list = new LinkedList<>();
        TreeNode next;
        while ((next = getNextSuccessor(stack)) != null) {
            if (next.val != target) {
                list.add(next);
            }
        }
        return list;
    }

    private void buildSuccessorStack(TreeNode root, Stack<TreeNode> stack, int target) {
        for (TreeNode node = root; node != null; ) {
            if (target <= node.val) {
                stack.push(node);
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    private TreeNode getNextSuccessor(Stack<TreeNode> stack) {
        if (stack.isEmpty()) {
            return null;
        }
        TreeNode ret = stack.pop();
        for (TreeNode node = ret.right; node != null; node = node.left) {
            stack.push(node);
        }
        return ret;
    }

    public List<TreeNode> getAllPredesessor(TreeNode root, int target) {
        Stack<TreeNode> stack = new Stack<>();
        buildPredesessorStack(root, stack, target);
        List<TreeNode> list = new LinkedList<>();
        TreeNode next;
        while ((next = getNextPredesessor(stack)) != null) {
            if (next.val != target) {
                list.add(next);
            }
        }
        return list;
    }

    private void buildPredesessorStack(TreeNode root, Stack<TreeNode> stack, int target) {
        for (TreeNode node = root; node != null; ) {
            if (target >= node.val) {
                stack.push(node);
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }

    private TreeNode getNextPredesessor(Stack<TreeNode> stack) {
        if (stack.isEmpty()) {
            return null;
        }
        TreeNode ret = stack.pop();
        for (TreeNode node = ret.left; node != null; node = node.right) {
            stack.push(node);
        }
        return ret;
    }
}
