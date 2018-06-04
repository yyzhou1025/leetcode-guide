package com.leetcode.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 2017/9/3.
 */

public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, List<String>> cache = new HashMap<>();
        cache.put("", Arrays.asList(""));
        return dfs(s, new HashSet<String>(wordDict), cache);
    }

    private List<String> dfs(String s, HashSet<String> wordDict, HashMap<String, List<String>> cache) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        List<String> result = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            String t = s.substring(i);
            if (wordDict.contains(t)) {
                List<String> list = dfs(s.substring(0, i), wordDict, cache);
                if (list != null) {
                    for (String ss : list) {
                        result.add((ss.length() > 0 ? ss + " " : "") + t);
                    }
                }
            }
        }
        cache.put(s, result);
        return result;
    }


}
