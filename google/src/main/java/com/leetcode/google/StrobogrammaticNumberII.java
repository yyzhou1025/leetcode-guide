package com.leetcode.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 2017/8/31.
 */

public class StrobogrammaticNumberII {


    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    private List<String> helper(int k, int n) {
        if (k == 0) {
            return Arrays.asList("");
        } else if (k == 1) {
            return Arrays.asList("0", "1", "8");
        }
        List<String> result = new LinkedList<>();
        for (String s : helper(k - 2, n)) {
            if (k != n) {
                result.add("0" + s + "0");
            }

            result.add("1" + s + "1");
            result.add("8" + s + "8");
            result.add("6" + s + "9");
            result.add("9" + s + "6");
        }
        return result;
    }
}
