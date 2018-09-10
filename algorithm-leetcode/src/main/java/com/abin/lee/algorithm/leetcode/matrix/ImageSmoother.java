package com.abin.lee.algorithm.leetcode.matrix;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/9/10.
 * LeetCode 661. Image Smoother （图像平滑器）
 * https://leetcode.com/problems/image-smoother/description/
 * https://www.cnblogs.com/jimmycheng/p/7697511.html
 */
public class ImageSmoother {

    public int[][] imageSmoother(int[][] M) {
        int r = M.length;
        int c = M[0].length;
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int sum = 0;
                int count = 0;
                for (int k = Math.max(0, i - 1); k < Math.min(i + 1, r - 1); k++) {
                    for (int l = Math.max(0, j - 1); l < Math.min(j + 1, c - 1); l++) {
                        sum += M[k][l];
                        count++;
                    }
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }

    /**
     * Example 1:
     * Input:
     * [[1,1,1],
     * [1,0,1],
     * [1,1,1]]
     * Output:
     * [[0, 0, 0],
     * [0, 0, 0],
     * [0, 0, 0]]
     * Explanation:
     * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
     * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
     * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] params = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},
        };
//        int[][] params = {
//                {1, 0},
//                {1, 1},
//        };
//        int[][] result = new ImageSmoother().imageSmoother(params);
        int[][] result = new ImageSmoother().imageSmoother(params);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

}
