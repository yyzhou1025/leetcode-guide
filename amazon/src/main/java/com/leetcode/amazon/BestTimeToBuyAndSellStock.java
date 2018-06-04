package com.leetcode.amazon;

/**
 * Created by liwentian on 17/8/10.
 */

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0, min = Integer.MAX_VALUE;

        for (int price : prices) {
            int profit = price - min;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            min = Math.min(min, price);
        }

        return maxProfit;
    }
}
