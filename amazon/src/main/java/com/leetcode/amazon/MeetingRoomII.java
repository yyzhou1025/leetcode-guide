package com.leetcode.amazon;

import com.leetcode.library.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by liwentian on 17/8/14.
 */

public class MeetingRoomII {


    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval t1) {
                return interval.start - t1.start;
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer - t1;
            }
        });

        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (queue.isEmpty() || intervals[i].start < queue.peek()) {
                count++;
            } else {
                queue.poll();
            }
            queue.offer(intervals[i].end);
        }

        return count;
    }
}
