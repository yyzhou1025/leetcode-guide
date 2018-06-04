package com.inuker.solution;

import java.util.HashMap;

/**
 * Created by dingjikerbo on 2016/12/15.
 */

/**
 * 支持相同数存在
 */
public class TwoSumIII {

    private HashMap<Integer, Integer> mMap;

    public TwoSumIII() {
        mMap = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        mMap.put(number, mMap.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Integer n : mMap.keySet()) {
            int cnt = mMap.getOrDefault(value - n, 0);
            if (value - n != n && cnt > 0) {
                return true;
            }
            if (value - n == n && cnt > 1) {
                return true;
            }
        }
        return false;
    }
}
