package com.leetcode.amazon;

/**
 * Created by liwentian on 17/8/13.
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[256];

        int maxLen = 0;

        for (int i = 0, j = 0; j < s.length(); ) {
            if (count[s.charAt(j)] == 0) {
                count[s.charAt(j)]++;
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            } else {
                --count[s.charAt(i++)];
            }
        }

        return maxLen;
    }
}
