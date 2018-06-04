package com.leetcode.amazon;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 17/8/9.
 */

public class FindAllAnagramsInAString {

    // abacbabc -> abc
    public List<Integer> findAnagrams(String s, String p) {
        int[] count = new int[26], temp = new int[26];

        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }

        List<Integer> result = new LinkedList<>();

        int sl = s.length(), pl = p.length();
        for (int start = 0, end = 0; end < sl; ) {
            char c = s.charAt(end);

            if (count[c - 'a'] == 0) {
                if (start <= end) {
                    temp[s.charAt(start++) - 'a']--;
                } else {
                    end++;
                }
                continue;
            }

            if (temp[c - 'a'] >= count[c - 'a']) {
                temp[s.charAt(start++) - 'a']--;
                continue;
            }

            temp[c - 'a']++;

            if (end - start + 1 == pl) {
                result.add(start);
                temp[s.charAt(start++) - 'a']--;
            }

            end++;
        }

        return result;
    }
}
