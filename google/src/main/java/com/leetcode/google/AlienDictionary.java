package com.leetcode.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by liwentian on 2017/9/2.
 */

public class AlienDictionary {

    public String alienOrder(String[] words) {
        HashMap<Character, Set<Character>> map = new HashMap<>();

        int[] indegrees = new int[26];
        Arrays.fill(indegrees, -1);

        int count = 0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (indegrees[c - 'a'] != 0) {
                    indegrees[c - 'a'] = 0;
                    count++;
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String prev = words[i], next = words[i + 1];

            for (int j = 0; j < prev.length() && j < next.length(); j++) {
                char c1 = prev.charAt(j), c2 = next.charAt(j);

                if (c1 != c2) {
                    Set<Character> set = map.get(c1);
                    if (set == null) {
                        set = new HashSet<>();
                        map.put(c1, set);
                    }
                    if (set.add(c2)) {
                        indegrees[c2 - 'a']++;
                    }
                    break;
                } else {
                    if (j + 1 < prev.length() && j + 1 >= next.length()) {
                        return "";
                    }
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (indegrees[c - 'a'] == 0) {
                queue.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);

            Set<Character> set = map.get(c);
            if (set != null) {
                for (char cc : set) {
                    if (--indegrees[cc - 'a'] == 0) {
                        queue.add(cc);
                    }
                }
            }
        }

        if (sb.length() != count) {
            return "";
        }

        return sb.toString();
    }
}
