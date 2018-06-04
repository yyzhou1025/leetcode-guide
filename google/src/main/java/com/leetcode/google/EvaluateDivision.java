package com.leetcode.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by liwentian on 2017/9/3.
 */

public class EvaluateDivision {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> valueMap = new HashMap<>();

        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            HashMap<String, Double> map = valueMap.get(equation[0]);
            if (map == null) {
                map = new HashMap<>();
                valueMap.put(equation[0], map);
            }
            map.put(equation[1], values[i]);

            map = valueMap.get(equation[1]);
            if (map == null) {
                map = new HashMap<>();
                valueMap.put(equation[1], map);
            }
            map.put(equation[0], 1 / values[i]);
        }

        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            double res = dfs(valueMap, queries[i][0], queries[i][1], new HashSet<String>(), 1.0);
            if (res == 0.0) {
                result[i] = -1.0;
            } else {
                result[i] = res;
            }
        }
        return result;
    }

    private double dfs(HashMap<String, HashMap<String, Double>> map, String start, String end, HashSet<String> set, double value) {
        if (set.contains(start)) {
            return 0.0;
        }
        if (!map.containsKey(start) || !map.containsKey(end)) {
            return 0.0;
        }
        if (start.equals(end)) {
            return value;
        }
        set.add(start);

        double res = 0.0;
        HashMap<String, Double> valueMap = map.get(start);
        for (Map.Entry<String, Double> entry : valueMap.entrySet()) {
            res = dfs(map, entry.getKey(), end, set, value * entry.getValue());
            if (res > 0) {
                break;
            }
        }
        set.remove(start);
        return res;
    }
}
