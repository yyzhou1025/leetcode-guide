package com.leetcode.google;

import java.util.List;

/**
 * Created by liwentian on 17/8/26.
 */

public class ValidWordSquare {

    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (word.length() > words.size()) {
                return false;
            }
            for (int j = 0; j < word.length(); j++) {
                String s = words.get(j);
                if (i >= s.length() || word.charAt(j) != s.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
