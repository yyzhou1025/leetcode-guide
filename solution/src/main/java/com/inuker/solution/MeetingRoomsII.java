package com.inuker.solution;

import com.leetcode.library.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by dingjikerbo on 16/11/20.
 */

public class MeetingRoomsII {

    // 耗时17ms，时间复杂度O(nlgn)
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Queue<Interval> queue = new PriorityQueue<Interval>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        for (Interval interval : intervals) {
            if (!queue.isEmpty() && interval.start >= queue.peek().end) {
                queue.poll();
            }
            queue.add(interval);
        }
        return queue.size();
    }
}
