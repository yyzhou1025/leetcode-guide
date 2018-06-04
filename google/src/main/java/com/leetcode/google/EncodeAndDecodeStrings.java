package com.leetcode.google;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 2017/8/30.
 */

public class EncodeAndDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("/").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < s.length(); ) {
            int index = s.indexOf("/", i);
            int size = Integer.parseInt(s.substring(i, index));
            i = index + 1 + size;
            list.add(s.substring(index + 1, i));
        }
        return list;
    }
}
