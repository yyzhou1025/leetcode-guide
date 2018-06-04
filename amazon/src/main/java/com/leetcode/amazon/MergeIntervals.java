package com.leetcode.amazon;

import com.leetcode.library.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 17/8/14.
 */

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval t1) {
                return interval.start - t1.start;
            }
        });

        List<Interval> result = new LinkedList<>();

        Interval curInterval = null;

        for (Interval interval : intervals) {
            if (curInterval == null) {
                curInterval = interval;
            } else if (interval.start <= curInterval.end) {
                curInterval.end = Math.max(curInterval.end, interval.end);
            } else {
                result.add(curInterval);
                curInterval = interval;
            }
        }

        if (curInterval != null) {
            result.add(curInterval);
        }

        return result;
    }
}
