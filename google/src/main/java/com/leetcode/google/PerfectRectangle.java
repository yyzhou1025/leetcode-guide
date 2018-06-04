package com.leetcode.google;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by liwentian on 2017/8/31.
 */

public class PerfectRectangle {

    public boolean isRectangleCover(int[][] rectangles) {

        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
        int x2 = 0, y2 = 0;

        HashSet<String> set = new HashSet<>();

        int area = 0;

        for (int[] rect : rectangles) {
            int left = rect[0];
            int bottom = rect[1];
            int right = rect[2];
            int top = rect[3];

            area += (right - left) * (top - bottom);

            x1 = Math.min(left, x1);
            y1 = Math.min(bottom, y1);
            x2 = Math.max(right, x2);
            y2 = Math.max(top, y2);

            String s1 = left + "." + bottom;
            String s2 = left + "." + top;
            String s3 = right + "." + bottom;
            String s4 = right + "." + top;

            if (!set.add(s1)) {
                set.remove(s1);
            }

            if (!set.add(s2)) {
                set.remove(s2);
            }

            if (!set.add(s3)) {
                set.remove(s3);
            }

            if (!set.add(s4)) {
                set.remove(s4);
            }
        }

        String s1 = x1 + "." + y1;
        String s2 = x1 + "." + y2;
        String s3 = x2 + "." + y1;
        String s4 = x2 + "." + y2;

        if (!set.contains(s1) || !set.contains(s2) || !set.contains(s3) || !set.contains(s4) || set.size() != 4) {
            return false;
        }

        return area == (x2 - x1) * (y2 - y1);
    }
}
