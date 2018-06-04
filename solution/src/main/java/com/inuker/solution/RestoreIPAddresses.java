package com.inuker.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 2017/9/6.
 */

public class RestoreIPAddresses {

    /**
     * 注意，0可以，但是00，01， 010这种是不允许的
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new LinkedList<>();
        dfs(s, list, 0, 0, "");
        return list;
    }

    private void dfs(String s, List<String> list, int index, int count, String cur) {
        if (index >= s.length()) {
            if (count == 4) {
                list.add(cur);
            }
            return;
        }

        if (count == 4) {
            return;
        }

        int[][] RANGES = {
                {0, 0}, {0, 9}, {10, 99}, {100, 255}
        };
        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String t = s.substring(index, index + i);
            int n = Integer.parseInt(t);
            if (n >= RANGES[i][0] && n <= RANGES[i][1]) {
                dfs(s, list, index + i, count + 1, (cur.isEmpty() ? "" : cur + ".") + t);
            }
        }
    }
}
