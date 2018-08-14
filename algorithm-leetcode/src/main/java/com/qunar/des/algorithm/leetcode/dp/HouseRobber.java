package com.qunar.des.algorithm.leetcode.dp;

/**
 * Created by abin on 2018/8/14.
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/description/
 * [LeetCode] 198. House Robber 打家劫舍
 * https://www.cnblogs.com/lightwindy/p/8648410.html
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length <= 1)
            return nums[0] == 0 ? 0 : nums[0];
        int pre = nums[0];
        int cur = Math.max(pre, nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = temp;
        }
        return cur;
    }


    /**
     * 假设你是一位专业的盗贼计划打劫沿一条街的房子，每个房子藏着一定数额的钱，你不能同时打劫相邻的两个房子，因为会报警，求一晚上能打劫到的最多钱。
     * 解法：动态规划DP。本质相当于在一列数组中取出一个或多个不相邻数，使其和最大。
     * State: dp[i]，表示到第i个房子时能够抢到的最大金额。
     * Function: dp[i] = max(num[i] + dp[i - 2], dp[i - 1])
     * Initialize: dp[0] = num[0], dp[1] = max(num[0], num[1]) 或者 dp[0] = 0, dp[1] = 0
     * Return: dp[n]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int result = new HouseRobber().rob(nums);
        System.out.println("result=" + result);
    }




}
