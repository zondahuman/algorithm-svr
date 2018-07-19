package com.qunar.des.algorithm.nowcoder;

/**
 * Created by abin on 2018/7/18.
 * 变态跳台阶
 题目描述
 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class JumpFloorII {
    public static void main(String[] args) {
        int result = new JumpFloorII().JumpFloorII(3);
        System.out.println("result="+result);
    }

    public int JumpFloorII(int target) {
        if(target <= 0 ) return 0;
        int[] dp = new int[target+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=target;i++){
            dp[i] = 0;
            for (int j = 0; j <i ; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target];
    }



}