package com.inuker.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by dingjikerbo on 2016/12/17.
 */

public class CourseSchedule {

    /**
     * 这题就是典型的拓扑排序
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pos : prerequisites) {
            Set<Integer> set = map.getOrDefault(pos[1], new HashSet<>());
            map.put(pos[1], set);
            if (set.add(pos[0])) {
                indegrees[pos[0]]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        for ( ; !queue.isEmpty(); numCourses--) {
            int n = queue.poll();
            for (Integer k : map.getOrDefault(n, new HashSet<>())) {
                if (--indegrees[k] == 0) {
                    queue.offer(k);
                }
            }
        }
        return numCourses == 0;
    }
}
