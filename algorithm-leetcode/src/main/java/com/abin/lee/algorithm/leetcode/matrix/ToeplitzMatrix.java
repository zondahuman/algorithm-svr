package com.abin.lee.algorithm.leetcode.matrix;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/9/10.
 * 766. Toeplitz Matrix 托普利茨矩阵
 * 每一条对角线元素的比较
 * https://leetcode.com/problems/toeplitz-matrix/description/
 */
public class ToeplitzMatrix {

    public static void main(String[] args) {
//        int[][] params = {
//                {1,2,3,4},
//                {5,1,2,3},
//                {9,5,1,2},
//        };
        int[][] params = {
                {1, 2},
                {2, 2},
        };
        boolean result = new ToeplitzMatrix().isToeplitzMatrix(params);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > 0 && j > 0 && matrix[i - 1][j - 1] != matrix[i][j])
                    return false;
            }
        }
        return true;
    }


}
