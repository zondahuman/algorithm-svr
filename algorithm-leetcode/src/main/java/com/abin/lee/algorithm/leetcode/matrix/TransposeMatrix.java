package com.abin.lee.algorithm.leetcode.matrix;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/9/10.
 * 867. Transpose Matrix
 * 转置矩阵
 * https://leetcode.com/problems/transpose-matrix/description/
 */
public class TransposeMatrix {
    /**
     * 给定一个矩阵 A， 返回 A 的转置矩阵。
     * <p>
     * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[][] params = {
//                {1, 2, 3}, {4, 5, 6}, {7, 8, 9},
//        };
        int[][] params = {
                {1, 2, 3}, {4, 5, 6},
        };
        int[][] result = new TransposeMatrix().transpose(params);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

    public int[][] transpose(int[][] A) {
        int[][] transpose = new int[A[0].length][A.length];
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                transpose[i][j] = A[j][i];
            }
        }
        return transpose;
    }


}
