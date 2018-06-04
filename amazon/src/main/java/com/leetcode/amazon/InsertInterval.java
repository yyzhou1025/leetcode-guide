package com.leetcode.amazon;

import com.leetcode.library.Interval;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 17/8/14.
 */

public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();

        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);

            if (newInterval.start > interval.end) {
                result.add(interval);
            } else if (newInterval.end < interval.start) {
                result.add(newInterval);
                newInterval = interval;
            } else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }

        if (newInterval != null) {
            result.add(newInterval);
        }

        return result;
    }
}
