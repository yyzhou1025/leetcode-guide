package com.leetcode.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by liwentian on 17/8/10.
 */

public class InsertDeleteGetRandom {

    private HashMap<Integer, Integer> mMap;

    private List<Integer> mList;

    private Random mRandom;

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandom() {
        mMap = new HashMap<>();
        mList = new ArrayList<>();
        mRandom = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (mMap.containsKey(val)) {
            return false;
        }
        mMap.put(val, mList.size());
        mList.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!mMap.containsKey(val)) {
            return false;
        }

        int idx = mMap.remove(val);

        if (idx != mList.size() - 1) {
            int tail = mList.get(mList.size() - 1);
            mList.set(idx, tail);
            mMap.put(tail, idx);
        }

        mList.remove(mList.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if (mList.isEmpty()) {
            return -1;
        }
        int idx = mRandom.nextInt(mList.size());
        return mList.get(idx);
    }
}
