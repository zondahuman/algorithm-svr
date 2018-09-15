package com.abin.lee.algorithm.leetcode.matrix;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/9/15.
 * 733. Flood Fill
 * 填充图像
 * https://leetcode.com/problems/flood-fill/description/
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor)
            floodFillDfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public void floodFillDfs(int[][] image, int sr, int sc, int newColor, int cur) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != cur)
            return;
        image[sr][sc] = newColor;
        floodFillDfs(image, sr - 1, sc, newColor, cur);
        floodFillDfs(image, sr + 1, sc, newColor, cur);
        floodFillDfs(image, sr, sc - 1, newColor, cur);
        floodFillDfs(image, sr, sc + 1, newColor, cur);
    }

    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        floodFill2Dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void floodFill2Dfs(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        floodFill2Dfs(image, sr + 1, sc, color, newColor);
        floodFill2Dfs(image, sr - 1, sc, color, newColor);
        floodFill2Dfs(image, sr, sc + 1, color, newColor);
        floodFill2Dfs(image, sr, sc - 1, color, newColor);
    }
    /**
     * Input:
     * image = [[1,1,1],[1,1,0],[1,0,1]]
     * sr = 1, sc = 1, newColor = 2
     * Output: [[2,2,2],[2,2,0],[2,0,1]]
     * Explanation:
     * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
     * by a path of the same color as the starting pixel are colored with the new color.
     * Note the bottom corner is not colored 2, because it is not 4-directionally connected
     * to the starting pixel.
     * 问题描述：给你一个int矩阵，起始坐标，sr,sc。新的数值newColor。将起始坐标数值改成newColor。并将与起始坐标上下左右相连的各个坐标，
     * 如果其值与起始坐标值相等的坐标也改成newColor，并重复此过程。简而言之，所有矩阵中与起始位置的数值相同的点。
     * 如果可以通过上下左右移动的方式到达起始位置，将数值改成newColor。
     * 思路：递归，再利用一个数组进行是否已更改此点的记录。避免两个相邻数字都是目标值结果无限递归。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int[][] matrix1 = {
                {2, 2, 2},
                {2, 2, 0},
                {2, 0, 1}
        };
        int[][] result = new FloodFill().floodFill(matrix, 1, 1, 2);
        System.out.println("result=" + JsonUtil.toJson(result));
    }


}
