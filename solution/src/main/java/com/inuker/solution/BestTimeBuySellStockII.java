package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/17.
 */

/**
 * https://leetcode.com/articles/best-time-buy-and-sell-stock-ii/
 */
public class BestTimeBuySellStockII {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
