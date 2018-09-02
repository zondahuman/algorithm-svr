package com.abin.lee.algorithm.leetcode.arrarer;

/**
 * Created by abin on 2018/9/2.
 * 322. Coin Change
 * 硬币找零
 * https://blog.csdn.net/happyaaaaaaaaaaa/article/details/50976088
 * https://leetcode.com/problems/coin-change/description/
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++)
            dp[i] = Integer.MAX_VALUE-1;
        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        return dp[amount] == Integer.MAX_VALUE-1 ? -1 : dp[amount];
    }

    /**
     * Example 1:
     * <p>
     * Input: coins = [1, 2, 5], amount = 11
     * Output: 3
     * Explanation: 11 = 5 + 5 + 1
     * Example 2:
     * <p>
     * Input: coins = [2], amount = 3
     * Output: -1
     *
     * @param args
     */
    public static void main(String[] args) {
        String hex= "0x7fff_fffe";
        System.out.println(Integer.toOctalString(0x7fff_fffe));
//        int[] nums = {1, 2, 5};
//        int target = 11;
        int[] nums = {2};
        int target = 3;
        int result = new CoinChange().coinChange(nums, target);
//        int result = new CoinChange().coinChange2(nums, target);
        System.out.println("result=" + result);
    }

    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = 0x7fffffff;
            for (int j = 0; j < coins.length; j++)
                if (i >= coins[j] && dp[i - coins[j]] != 0x7fffffff)  //①
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
        return dp[amount] == 0x7fffffff ? -1 : dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) dp[i] = 0x7fff_fffe;
        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        return dp[amount] == 0x7fff_fffe ? -1 : dp[amount];
    }

}
