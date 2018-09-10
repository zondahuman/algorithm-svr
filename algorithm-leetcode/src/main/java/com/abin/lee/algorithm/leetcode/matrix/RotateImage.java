package com.abin.lee.algorithm.leetcode.matrix;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/9/11.
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/description/
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
        System.out.println("matrix=" + JsonUtil.toJson(matrix));
    }

    public void rotate1(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    /**
     * Example 1:

     Given input matrix =
     [
     [1,2,3],
     [4,5,6],
     [7,8,9]
     ],

     rotate the input matrix in-place such that it becomes:
     [
     [7,4,1],
     [8,5,2],
     [9,6,3]
     ]
     * @param args
     */
    public static void main(String[] args) {
        int[][] params = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
//        int[][] params = {
//                {1, 0},
//                {1, 1},
//        };
//        new RotateImage().rotate1(params);
        new RotateImage().rotate(params);
        System.out.println("params=" + JsonUtil.toJson(params));
    }

}
