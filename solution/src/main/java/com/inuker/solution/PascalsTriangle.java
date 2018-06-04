package com.inuker.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liwentian on 2017/9/10.
 */

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            allrows.add(new ArrayList<>(row));
        }
        return allrows;

    }
}
