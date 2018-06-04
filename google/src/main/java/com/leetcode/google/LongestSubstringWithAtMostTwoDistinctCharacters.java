package com.leetcode.google;

/**
 * Created by liwentian on 17/8/22.
 */

public class LongestSubstringWithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] count = new int[256];
        int distinct = 0, longest = 0;

        for (int i = 0, j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) {
                distinct++;
            }

            for ( ; i < j && distinct > 2; ) {
                if (--count[s.charAt(i++)] == 0) {
                    --distinct;
                }
            }

            longest = Math.max(longest, j - i + 1);
        }

        return longest;
    }
}
