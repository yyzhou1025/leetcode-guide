package com.leetcode.facebook;

/**
 * Created by liwentian on 17/8/17.
 */

public class ReadNCharactersGivenRead4II {

    int idx = 0, size = 0;
    char[] tmp = new char[4];

    public int read(char[] buf, int n) {
        int i = 0;

        for ( ; i < n; ) {
            if (idx >= size) {
                size = read4(tmp);
                idx = 0;
            }

            for ( ; idx < size && i < n; ) {
                buf[i++] = tmp[idx++];
            }

            if (size < 4) {
                break;
            }
        }

        return i;
    }

    int read4(char[] buf) {
        return 0;
    }
}
