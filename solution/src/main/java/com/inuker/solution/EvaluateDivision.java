package com.inuker.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by liwentian on 2017/9/3.
 */

/**
 * 1, 首先给除的结果都存起来，建立有向图
 * 2，用DFS遍历路径
 */
public class EvaluateDivision {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> valueMap = new HashMap<>();

        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            HashMap<String, Double> map = valueMap.computeIfAbsent(equation[0], k -> new HashMap<>());
            map.put(equation[1], values[i]);
            map = valueMap.computeIfAbsent(equation[1], k -> new HashMap<>());
            map.put(equation[0], 1 / values[i]);
        }

        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            double[] value = new double[] {1.0};
            result[i] = dfs(valueMap, queries[i][0], queries[i][1], new HashSet<>(), value) ? value[0] : -1.0;
        }
        return result;
    }

    private boolean dfs(HashMap<String, HashMap<String, Double>> map, String start, String end, HashSet<String> set, double[] value) {
        if (!map.containsKey(start) || !map.containsKey(end) || set.contains(start)) {
            return false;
        }
        if (start.equals(end)) {
            return true;
        }
        set.add(start);
        HashMap<String, Double> valueMap = map.get(start);
        boolean flag = false;
        for (Map.Entry<String, Double> entry : valueMap.entrySet()) {
            value[0] *= entry.getValue();
            if (dfs(map, entry.getKey(), end, set, value)) {
                flag = true;
                break;
            }
            value[0] /= entry.getValue();
        }
        set.remove(start);
        return flag;
    }
}
