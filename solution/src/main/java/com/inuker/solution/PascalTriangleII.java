package com.inuker.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liwentian on 17/8/12.
 */

public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            int prev = 1;
            for (int j = 1; j < list.size(); j++) {
                int n = list.get(j) + prev;
                prev = list.get(j);
                list.set(j, n);
            }
            list.add(1);
        }

        return list;
    }

}
