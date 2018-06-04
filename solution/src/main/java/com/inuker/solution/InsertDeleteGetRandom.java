package com.inuker.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

/**
 * 有几点要注意：
 * remove时要判断删除的是不是最后一个，另外交换了结尾后要更新结尾数的idx
 */
// 耗时111ms
public class InsertDeleteGetRandom {

    private HashMap<Integer, Integer> mMap;
    private List<Integer> mList;
    private Random mRandom;

    public InsertDeleteGetRandom() {
        mList = new ArrayList<Integer>();
        mMap = new HashMap<Integer, Integer>();
        mRandom = new Random();
    }

    public boolean insert(int val) {
        if (mMap.containsKey(val)) {
            return false;
        }
        mList.add(val);
        mMap.put(val, mList.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!mMap.containsKey(val)) {
            return false;
        }
        int index = mMap.remove(val);
        int lastIndex = mList.size() - 1;
        if (index != lastIndex) {
            int lastVal = mList.get(lastIndex);
            mList.set(index, lastVal);
            // 这里要注意重新设置lastVal的index
            mMap.put(lastVal, index);
        }
        mList.remove(lastIndex);
        return true;
    }

    public int getRandom() {
        int index = mRandom.nextInt(mList.size());
        return mList.get(index);
    }
}
