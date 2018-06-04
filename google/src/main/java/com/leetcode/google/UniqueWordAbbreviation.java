package com.leetcode.google;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by liwentian on 2017/8/30.
 */

public class UniqueWordAbbreviation {

    private HashMap<String, HashSet<String>> mMap;

    public UniqueWordAbbreviation(String[] dictionary) {
        mMap = new HashMap<>();
        for (String s : dictionary) {
            String t = abbr(s);
            HashSet<String> set = mMap.get(t);
            if (set == null) {
                set = new HashSet<>();
                mMap.put(t, set);
            }
            set.add(s);
        }
    }

    private String abbr(String s) {
        return s.length() > 2 ? s.charAt(0) + String.valueOf(s.length() - 2) + s.charAt(s.length() - 1) : s;
    }

    public boolean isUnique(String word) {
        String t = abbr(word);
        HashSet<String> set = mMap.get(t);
        return set == null || (set.size() == 1 && set.contains(word));
    }
}
