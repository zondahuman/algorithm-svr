package com.abin.lee.algorithm.leetcode.matrix;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by abin on 2018/9/5.
 * 542. 01 Matrix
 * https://leetcode.com/problems/01-matrix/description/
 * 零一矩阵
 * https://blog.csdn.net/u014688145/article/details/64126559
 */
public class Matrix {

    public int[][] updateMatrix(int[][] matrix) {
        int rowNum = matrix.length; //行数
        int columnNum = matrix[0].length; //列数
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < columnNum; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int row = cell[0] + d[0];
                int column = cell[1] + d[1];
                if (row < 0 || row >= rowNum || column < 0 || column >= columnNum || matrix[row][column] <= matrix[cell[0]][cell[1]] + 1)
                    continue;
                queue.add(new int[]{row, column});
                matrix[row][column] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        return matrix;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        int[][] result = new Matrix().updateMatrix(matrix);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

}
