package com.leetcode.amazon;

import java.util.Stack;

/**
 * Created by liwentian on 17/8/10.
 */

public class MinStack {

    private Stack<Integer> mStack;
    private Stack<Integer> mStack2;

    public MinStack() {
        mStack = new Stack<Integer>();
        mStack2 = new Stack<>();
    }

    public void push(int x) {
        mStack.push(x);

        if (mStack2.isEmpty() || x < mStack2.peek()) {
            mStack2.push(x);
        } else {
            mStack2.push(mStack2.peek());
        }
    }

    public void pop() {
        mStack.pop();
        mStack2.pop();
    }

    public int top() {
        return mStack.peek();
    }

    public int getMin() {
        return mStack2.peek();
    }
}
