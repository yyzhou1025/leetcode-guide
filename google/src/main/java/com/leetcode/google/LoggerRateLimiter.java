package com.leetcode.google;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 2017/8/31.
 */

public class LoggerRateLimiter {

    private HashMap<String, Integer> mMap;

    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        mMap = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int time = mMap.getOrDefault(message, -100);
        if (timestamp - time >= 10) {
            mMap.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}
