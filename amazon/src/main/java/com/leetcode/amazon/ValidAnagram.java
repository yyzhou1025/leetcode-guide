package com.leetcode.amazon;

/**
 * Created by liwentian on 17/8/11.
 */

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            count[t.charAt(i)]--;
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
