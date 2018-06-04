package com.inuker.solution;

/**
 * Created by liwentian on 17/8/12.
 */

/**
 * 这题注意边界情况
 */
public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        int count = 0;

        long first = (long) Integer.MIN_VALUE - 1;
        long second = (long) Integer.MIN_VALUE - 1;
        long third = (long) Integer.MIN_VALUE - 1;

        for (int n : nums) {
            if (n == first || n == second || n == third) {
                continue;
            }

            if (n > first) {
                count++;
                third = second;
                second = first;
                first = n;
            } else if (n > second) {
                count++;
                third = second;
                second = n;
            } else if (n >= third) {
                count++;
                third = n;
            }
        }

        return (int) (count >= 3 ? third : first);
    }
}
