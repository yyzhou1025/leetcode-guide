package com.leetcode.google;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 2017/8/30.
 */

public class NumberOfIslandsII {

    private int[] mRoot;

    private int mCount;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        mRoot = new int[m * n];

        Arrays.fill(mRoot, -1);

        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        List<Integer> list = new LinkedList<>();

        for (int[] pos : positions) {
            int k = pos[0] * n + pos[1];

            mRoot[k] = k;

            mCount++;

            for (int i = 0; i < dx.length; i++) {
                for (int j = 0; j < dy.length; j++) {
                    int x = pos[0] + dx[i], y = pos[1] + dy[i], z = x * n + y;
                    if (x < 0 || x >= m || y < 0 || y >= n || mRoot[z] == -1) {
                        continue;
                    }
                    union(k, z);
                }
            }

            list.add(mCount);
        }

        return list;
    }

    private void union(int z, int z0) {
        int z1 = find(z);
        int z2 = find(z0);
        if (z1 != z2) {
            mRoot[z1] = z2;
            mCount--;
        }
    }

    private int find(int z) {
        while (mRoot[z] != z) {
            z = mRoot[z];
        }
        return z;
    }
}
