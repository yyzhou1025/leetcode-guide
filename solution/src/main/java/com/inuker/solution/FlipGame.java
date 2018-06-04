package com.inuker.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 2017/9/6.
 */

public class FlipGame {

    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < s.length(); ) {
            int index = s.indexOf("++", i);
            if (index >= i) {
                result.add(s.substring(0, index) + "--" + s.substring(index + 2));
                i = index + 1;
            } else {
                break;
            }
        }
        return result;
    }
}
