package com.leetcode.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dingjikerbo on 2017/8/6.
 */

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }


    private void bfs(char[][] grid, int i0, int j0) {
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i0, j0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1];

            for (int k = 0; k < dx.length; k++) {
                int x = i + dx[k], y = j + dy[k];
                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') {
                    continue;
                }
                grid[x][y] = '0';
                queue.add(new int[] {x, y});
            }
        }
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
