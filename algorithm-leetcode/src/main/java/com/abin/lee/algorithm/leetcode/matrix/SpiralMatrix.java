package com.abin.lee.algorithm.leetcode.matrix;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abin on 2018/9/10.
 * 54. Spiral Matrix
 * 螺旋矩阵
 * https://leetcode.com/problems/spiral-matrix/description/
 */
public class SpiralMatrix {

    /**
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * Output: [1,2,3,6,9,8,7,4,5]
     * Example 2:
     * <p>
     * Input:
     * [
     * [1, 2, 3, 4],
     * [5, 6, 7, 8],
     * [9,10,11,12]
     * ]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        List<Integer> result = new SpiralMatrix().spiralOrder(matrix);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int columnStart = 0;
        int columnEnd = matrix[0].length - 1;
        while (rowStart <= rowEnd && columnStart <= columnEnd) {
            for (int i = columnStart; i <= columnEnd; i++) {
                list.add(matrix[rowStart][i]);
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                list.add(matrix[i][columnEnd]);
            }
            columnEnd--;
            if (rowStart <= rowEnd) {
                for (int i = columnEnd; i >= columnStart; i--) {
                    list.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            if (columnStart <= columnEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    list.add(matrix[i][columnStart]);
                }
            }
            columnStart++;
        }
        return list;
    }


}
