package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/26.
 */

public class SegmentTreeNode {

    public SegmentTreeNode left, right;

    public int sum;

    public int start, end;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
