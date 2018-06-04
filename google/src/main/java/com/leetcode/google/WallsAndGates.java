package com.leetcode.google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liwentian on 2017/9/1.
 */

public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> next = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        int level = 0;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];

            if (rooms[x][y] == Integer.MAX_VALUE) {
                rooms[x][y] = level;
            }

            int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
            for (int m = 0; m < dx.length; m++) {
                int x0 = x + dx[m], y0 = y + dy[m];
                if (x0 < 0 || x0 >= rooms.length || y0 < 0 || y0 >= rooms[0].length) {
                    continue;
                }
                if (rooms[x0][y0] != Integer.MAX_VALUE) {
                    continue;
                }
                next.add(new int[] {x0, y0});
            }

            if (queue.isEmpty()) {
                queue.addAll(next);
                next.clear();
                level++;
            }
        }
    }
}
