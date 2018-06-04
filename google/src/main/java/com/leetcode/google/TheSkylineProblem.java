package com.leetcode.google;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by liwentian on 2017/8/31.
 */

public class TheSkylineProblem {

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> list = new LinkedList<>();
        for (int[] building : buildings) {
            list.add(new int[] {building[0], -building[2]});
            list.add(new int[] {building[1], building[2]});
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        List<int[]> result = new LinkedList<>();

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.<Integer>reverseOrder());
        queue.add(0);

        int prev = 0;
        for (int[] pos : list) {
            if (pos[1] < 0) {
                queue.add(-pos[1]);
            } else {
                queue.remove(pos[1]);
            }

            int cur = queue.peek();
            if (cur != prev) {
                result.add(new int[] {pos[0], cur});
                prev = cur;
            }
        }

        return result;
    }
}
