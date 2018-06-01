package com.qunar.des.algorithm.special.basic.test.topic;

import java.util.Arrays;

/**
 * Created by abin on 2018/6/1 20:26.
 * algorithm-svr
 * com.qunar.des.algorithm.special.basic.test.topic
 */
public class MartrixAllPathsTest {
    public static void main(String[] args) {
        int allPath = allPath(3, 5);
        System.out.println("allPath=" + allPath);
        int recursivePaths = recursivePaths(3, 5);
        System.out.println("recursivePaths=" + recursivePaths);
    }

    public static int allPath(int m, int n){
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                dp[j] = dp[j] + dp[j-1] ;
            }
        }
        return dp[n-1];
    }

    public static int recursivePaths(int m, int n){
        if(m ==1 || n ==1)
            return 1;
        int total = recursivePaths(m, n-1) + recursivePaths(m-1, n);
        return total ;
    }

}
