package com.leetcode.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by liwentian on 17/8/26.
 */

public class WordSquares {

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new LinkedList<>();
        if (words.length == 0) {
            return result;
        }
        HashMap<String, Set<String>> map = new HashMap<>();
        for (String word : words) {
            for (int i = -1; i < word.length(); i++) {
                String s = word.substring(0, i + 1);
                Set<String> set = map.get(s);
                if (set == null) {
                    set = new HashSet<>();
                    map.put(s, set);
                }
                set.add(word);
            }
        }

        helper(result, words[0].length(), map, new LinkedList<String>());
        return result;
    }

    private void helper(List<List<String>> result, int len, HashMap<String, Set<String>> map, List<String> list) {
        if (list.size() == len) {
            result.add(new LinkedList<>(list));
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).charAt(list.size()));
        }
        String prefix = sb.toString();
        Set<String> set = map.get(prefix);

        if (set == null) {
            return;
        }

        for (String s : set) {
            list.add(s);
            helper(result, len, map, list);
            list.remove(list.size() - 1);
        }
    }
}
