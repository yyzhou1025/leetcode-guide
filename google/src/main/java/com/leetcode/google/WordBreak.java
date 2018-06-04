package com.leetcode.google;

import java.util.HashSet;
import java.util.List;

/**
 * Created by liwentian on 2017/9/3.
 */

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int j = i - word.length();
                if (j >= 0 && dp[j] && s.substring(j, i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
