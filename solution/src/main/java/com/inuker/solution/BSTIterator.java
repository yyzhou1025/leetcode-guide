package com.inuker.solution;

import com.leetcode.library.TreeNode;

import java.util.Stack;

/**
 * Created by dingjikerbo on 16/11/21.
 */

public class BSTIterator {

    private Stack<TreeNode> mStack;
    private TreeNode mCurNode;

    public BSTIterator(TreeNode root) {
        mStack = new Stack<TreeNode>();
        mCurNode = root;

//        for (mCurNode = root; mCurNode != null; mCurNode = mCurNode.left) {
//            mStack.push(mCurNode);
//        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !mStack.isEmpty() || mCurNode != null;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        int result = -1;

        while (hasNext()) {
            if (mCurNode != null) {
                mStack.push(mCurNode);
                mCurNode = mCurNode.left;
            } else {
                mCurNode = mStack.pop();
                result = mCurNode.val;
                mCurNode = mCurNode.right;
                break;
            }
        }

        return result;
    }

    /** 这样写也好，不过要注意在构造函数中初始化如上注释部分
    public int next() {
        if (mCurNode == null) {
            mCurNode = mStack.pop();
        }

        int val = mCurNode.val;

        for (mCurNode = mCurNode.right; mCurNode != null; mCurNode = mCurNode.left) {
            mStack.push(mCurNode);
        }

        return val;
    }*/
}
