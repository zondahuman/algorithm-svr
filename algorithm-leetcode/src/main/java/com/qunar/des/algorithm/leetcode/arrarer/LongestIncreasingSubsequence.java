package com.qunar.des.algorithm.leetcode.arrarer;

/**
 * Created by abin on 2018/9/1.
 * 求数组的最长递增子序列
 * https://www.cnblogs.com/yrbbest/p/5047816.html
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 * https://leetcode.com/problems/longest-increasing-subsequence/discuss/74953/Java-solution-dp-simple
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i <nums.length ; i++) {
            dp[i] = 1;
            for (int j = 0; j <i ; j++) {
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    /**
     *
     * @param nums {1,2,1,3,5};
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 1;
        for (int index = 0; index < nums.length; index++) {
            dp[index] = 1;
            for (int dpIndex = 0; dpIndex < index; dpIndex++) {
                if (nums[dpIndex] < nums[index]) {
                    dp[index] = Math.max(dp[index], dp[dpIndex] + 1);
                    max = Math.max(dp[index], max);
                }
            }
        }
        return max;
    }
    /**
     * Input: [10,9,2,5,3,7,101,18]
     * Output: 4
     * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] param = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int[] param = new int[] {1,5,9,13,17};
//        int[] param = new int[] {1,2,1,3,5,6,4};
        int result = new LongestIncreasingSubsequence().lengthOfLIS(param);
//        int result = new LongestIncreasingSubsequence().lengthOfLIS1(param);
        System.out.println("result=" + result);
    }


    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length, max = 0;
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
