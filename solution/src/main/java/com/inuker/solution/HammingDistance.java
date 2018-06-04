package com.inuker.solution;

/**
 * Created by dingjikerbo on 17/1/7.
 */

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int k = 0;
        for (int i = x ^ y; i != 0; i &= i - 1, k++);
        return k;
    }
}
