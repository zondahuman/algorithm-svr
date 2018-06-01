package com.abin.lee.algorithm.special.basic.matrix;

/**
 * Created by abin on 2018/6/1 19:41.
 * algorithm-svr
 * com.abin.lee.algorithm.special.basic.matrix
 * 矩阵的最小路径和
 * https://github.com/zondahuman/Interview-Notebook/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3.md
 * https://blog.csdn.net/u013309870/article/details/69569456
 */
public class MartrixMinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int minPathSum = minPathSum(grid);
        System.out.println("minPathSum=" + minPathSum);
    }

    public static int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) dp[0] = dp[0] + grid[i][0];           // 只能从上侧走到该位置
                else if (i == 0) dp[j] = dp[j - 1] + grid[0][j];  // 只能从右侧走到该位置
                else dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }


    /**
     * 矩阵的最小路径和
     64. Minimum Path Sum (Medium)
     [[1,3,1],
     [1,5,1],
     [4,2,1]]
     Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
     */
}
