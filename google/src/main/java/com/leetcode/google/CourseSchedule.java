package com.leetcode.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by liwentian on 2017/9/2.
 */

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0], to = prerequisite[1];
            Set<Integer> set = map.get(from);
            if (set == null) {
                set = new HashSet<>();
                map.put(from, set);
            }
            if (set.add(to)) {
                indegrees[to]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            int n = queue.poll();
            list.add(n);

            Set<Integer> set = map.get(n);
            if (set != null) {
                for (Integer k : set) {
                    if (--indegrees[k] == 0) {
                        queue.offer(k);
                    }
                }
            }
        }

        return list.size() == numCourses;
    }
}
