package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/20.
 */

/**
 * TestCases
 * ""
 * "1"
 * "1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"
 * "7893749912342187894921836847319981199844151766195952528631828655978178193192959793156142441128167383"
 */
public class DecodeWays {

    /**
     * 超时了，有大量的字符串复制，不过思路挺直观的
     * 注意这里s为空时要返回0，但是在递归时s为空要返回1，所以为了区分这两种情况，分出了helper
     */
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        return helper(s);
    }

    public int helper(String s) {
        /**
         * 如果能一直正确匹配到结尾了是合法的
         */
        if (s.length() == 0) {
            return 1;
        }

        // 以0开头的是非法的
        if (s.charAt(0) == '0') {
            return 0;
        }

        int ways = 0;

        if (s.length() > 1 && (s.charAt(0) == '1' || (s.charAt(0) == '2' && (s.charAt(1) >= '0' && s.charAt(1) <= '6')))) {
            ways += helper(s.substring(2));
        }

        ways += helper(s.substring(1));

        return ways;
    }

    /**
    // 这里继续优化，为避免重复运算，对结果进行了缓存，性能非常好，耗时2ms
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] f = new int[s.length()];
        Arrays.fill(f, -1);
        return helper(s.toCharArray(), f, 0);
    }

    public int helper(char[] s, int[] f, int i) {
        if (i >= s.length) {
            return 1;
        }

        if (s[i] == '0') {
            return 0;
        }

        // 这里一定要包括等于0，因为0也是要缓存的，表示后面的子串都不可能合法，比如30.......
        if (f[i] >= 0) {
            return f[i];
        }

        int ways = 0;

        if (i < s.length - 1 && (s[i] == '1' || (s[i] == '2' && (s[i + 1] >= '0' && s[i + 1] <= '6')))) {
            ways += helper(s, f, i + 2);
        }

        f[i] = ways + helper(s, f, i + 1);

        return f[i];
    }
*/

    // DP，耗时2ms，复杂度O(n)
    public int numDecodings2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                f[i + 1] = f[i - 1];
            }
            if (s.charAt(i) != '0') {
                f[i + 1] += f[i];
            }
        }
        return f[n];
    }
}
