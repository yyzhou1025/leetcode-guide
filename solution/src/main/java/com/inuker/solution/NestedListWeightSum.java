package com.inuker.solution;

import java.util.List;

/**
 * Created by dingjikerbo on 2016/12/17.
 */

/**
 * https://leetcode.com/articles/nested-list-weight-sum/
 */
public class NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    private int depthSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;

        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                sum += depth * nest.getInteger();
            } else {
                sum += depthSum(nest.getList(), depth + 1);
            }
        }

        return sum;
    }
}
