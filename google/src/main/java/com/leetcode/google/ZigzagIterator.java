package com.leetcode.google;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liwentian on 17/8/26.
 */

public class ZigzagIterator {

    private List<Iterator<Integer>> mIterators = new ArrayList<>();

    private int mCurIdx;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        init(v1, v2);
    }

    private void init(List<Integer>... lists) {
        for (List<Integer> list : lists) {
            if (!list.isEmpty()) {
                mIterators.add(list.iterator());
            }
        }
    }

    public int next() {
        return mIterators.get(mCurIdx++).next();
    }

    public boolean hasNext() {
        while (!mIterators.isEmpty()) {
            mCurIdx %= mIterators.size();

            Iterator<Integer> cur = mIterators.get(mCurIdx);

            if (cur.hasNext()) {
                return true;
            }
            mIterators.remove(mCurIdx);
        }
        return false;
    }
}
