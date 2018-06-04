package com.leetcode.library;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/12/19.
 */

public class UndirectedGraphNode {

    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
