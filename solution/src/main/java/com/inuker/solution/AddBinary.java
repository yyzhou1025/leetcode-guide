package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/19.
 */

public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, k = 0;
        for ( ; i >= 0 || j >= 0 || k > 0; i--, j--) {
            int i0 = i >= 0 ? a.charAt(i) - '0' : 0;
            int j0 = j >= 0 ? b.charAt(j) - '0' : 0;
            int s = i0 + j0 + k;
            sb.insert(0, s & 1);
            k = s >> 1;
        }
        return sb.toString();
    }
}
