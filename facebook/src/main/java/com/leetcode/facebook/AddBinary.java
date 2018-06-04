package com.leetcode.facebook;

/**
 * Created by liwentian on 17/8/17.
 */

public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int flag = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || flag > 0; i--, j--) {
            int a1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int a2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = a1 + a2 + flag;
            sb.insert(0, sum & 1);
            flag = sum >> 1;
        }

        return sb.toString();
    }
}
