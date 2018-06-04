package com.leetcode.google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liwentian on 2017/8/30.
 */

public class ShortestDistanceFromAllBuildings {

    public int shortestDistance(int[][] grid) {
        if (grid.length == 0) {
            return -1;
        }
        int row = grid.length, col = grid[0].length;

        int[][] dis = new int[row][col];
        int[][] building = new int[row][col];
        int buildings = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }

                buildings++;
                bfs(grid, dis, building, i, j);
            }
        }

        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && building[i][j] == buildings) {
                    shortest = Math.min(shortest, dis[i][j]);
                }
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    private void bfs(int[][] grid, int[][] dis, int[][] building, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});

        Queue<int[]> next = new LinkedList<>();

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int level = 0;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x0 = pos[0], y0 = pos[1];

            dis[x0][y0] += level;
            building[x0][y0]++;

            int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

            for (int m = 0; m < dx.length; m++) {
                int x = x0 + dx[m], y = y0 + dy[m];

                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                    continue;
                }

                if (grid[x][y] == 0 && !visited[x][y]) {
                    visited[x][y] = true;
                    next.offer(new int[]{x, y});
                }
            }

            if (queue.isEmpty()) {
                queue.addAll(next);
                next.clear();
                level++;
            }
        }
    }
}
