package com.abin.lee.algorithm.leetcode.dp;

/**
 * Created by abin on 2018/8/7.
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * Complexity Analysis
 Time complexity : O(n)O(n). Only a single pass is needed.
 Space complexity : O(1)O(1). Only two variables are used.
 一次交易股票获取最大值
 */
public class BestTimeBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int maxBenifit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else {
                maxBenifit = Math.max(maxBenifit, prices[i]-minPrice);
            }
        }
        return maxBenifit;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        int result = new BestTimeBuyAndSellStock().maxProfit(nums);
        System.out.println("result=" + result);
    }

}
