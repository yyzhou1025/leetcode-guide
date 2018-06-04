package com.leetcode.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liwentian on 2017/9/3.
 */

public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];

        if (!dfs(graph, visited, 0, -1)) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<Integer>[] graph, boolean[] visited, int start, int parent) {
        visited[start] = true;

        for (int i = 0; i < graph[start].size(); i++) {
            int to = graph[start].get(i);
            if (to == parent) {
                continue;
            }
            if (visited[to]) {
                return false;
            }
            if (!dfs(graph, visited, to, start)) {
                return false;
            }
        }

        return true;
    }

}
