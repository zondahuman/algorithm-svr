package com.qunar.des.algorithm.leetcode.dp;

/**
 * Created by abin on 2018/8/7.
 * 122. Best Time to Buy and Sell Stock II
 https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 多次交易获取最大值
 */
public class BestTimeBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i] < prices[i+1])
                sum += prices[i+1] - prices[i];
        }
        return sum;
    }
    public int maxProfit1(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i] < prices[i+1])
                sum += prices[i+1] - prices[i];
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] nums = {7,1,5,3,6,4};
        int[] nums = {1,2,3,4,5};
//        int[] nums = {7,6,4,3,1};
//        int result = new BestTimeBuyAndSellStockII().maxProfit(nums);
        int result = new BestTimeBuyAndSellStockII().maxProfit1(nums);
        System.out.println("result=" + result);
    }


}
