package com.abin.lee.algorithm.special.basic.matrix;

import java.util.Arrays;

/**
 * Created by abin on 2018/6/1 18:52.
 * algorithm-svr
 * com.abin.lee.algorithm.special.basic.matrix
 * 矩阵的总路径数
 */
public class MatrixAllPaths {
    /**
     * 矩阵路径
     * 矩阵的总路径数
     * 62. Unique Paths (Medium)
     * 题目描述：统计从矩阵左上角到右下角的路径总数，每次只能向右或者向下移动。
     *
     * @param args
     */
    public static void main(String[] args) {
        int uniqueDpPaths = uniqueDpPaths(3, 5);
        System.out.println("uniqueDpPaths=" + uniqueDpPaths);
//        int uniqueCombinationPaths = uniqueCombinationPaths(3, 5);
//        int paths1 = uniqueCombinationPaths(5, 3);
//        System.out.println("uniqueCombinationPaths=" + uniqueCombinationPaths);
        int uniqueRecursivePaths = uniqueRecursivePaths(3, 5);
        System.out.println("uniqueRecursivePaths=" + uniqueRecursivePaths);
    }

    /**
     * 矩阵全路径递归实现
     * https://blog.csdn.net/zhouqianq/article/details/76922494
     * @param m
     * @param n
     * @return
     */
    public static int uniqueRecursivePaths(int m, int n)//递归
    {
        if (m == 1 || n == 1)
            return 1;
        int total = uniqueRecursivePaths(m - 1, n) + uniqueRecursivePaths(m, n - 1);
        return total;
    }

    /**
     * 矩阵的总路径数--动态规划
     * @param m
     * @param n
     * @return
     */
    public static int uniqueDpPaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    /**
     * 矩阵的总路径数--数学公式求解，组合问题
     * @param m
     * @param n
     * @return
     */
    public static int uniqueCombinationPaths(int m, int n) {
        int S = m + n - 2; // 总共的移动次数
        int D = m - 1;     // 向下的移动次数
        long ret = 1;
        for (int i = 1; i <= D; i++) {
            ret = ret * (S - D + i) / i;
        }
        return (int) ret;
    }



    /**
     * https://blog.csdn.net/li_chong/article/details/8881924
     * 1、数学解法求路径数
     (1)使用排列组合。因为只能向右走或者向下走，在(m-1)+(n-1)次行走后，才能到达终点，也就是右下角。而在这m+n-2次行走中，有m-1次是向下，n-1次向右，所以是一个选择问题：

     (2)水平行走记作0，竖直行走记作1。每一种行走足迹可以作为一个0,1串，其中n-1个0，m-1个1。可以看做0000000000000（n-1个0）1111111111111（m-1个1）的重排列，也就是：

     */

}
