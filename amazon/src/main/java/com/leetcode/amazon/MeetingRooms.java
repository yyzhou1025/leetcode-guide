package com.leetcode.amazon;

import com.leetcode.library.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by liwentian on 17/8/14.
 */

public class MeetingRooms {

    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval t1) {
                return interval.start - t1.start;
            }
        });

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }

        return true;
    }
}
