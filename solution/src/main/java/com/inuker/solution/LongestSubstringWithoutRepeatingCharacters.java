package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/17.
 */

/**
 * https://leetcode.com/articles/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    // 耗时39ms，性能挺好
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
