package com.leetcode.google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liwentian on 2017/8/29.
 */

public class MovingAverageFromDataStream {

    private int mSize;

    private Queue<Integer> mQueue;

    private double mSum;

    public MovingAverageFromDataStream(int size) {
        mSize = size;
        mQueue = new LinkedList<>();
    }

    public double next(int val) {
        mQueue.add(val);
        mSum += val;

        if (mQueue.size() > mSize) {
            mSum -= mQueue.poll();
        }

        return mSum / mQueue.size();
    }
}
