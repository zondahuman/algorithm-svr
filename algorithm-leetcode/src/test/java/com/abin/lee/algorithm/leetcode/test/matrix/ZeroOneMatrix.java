package com.abin.lee.algorithm.leetcode.test.matrix;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by abin on 2018/9/10.
 */
public class ZeroOneMatrix {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {0, 0, 0},
//                {0, 0, 0},
//                {0, 1, 0},
//        };
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
        };
        int[][] result = new ZeroOneMatrix().matrix(matrix);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

    public static int[][] matrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] position = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] temp : position) {
                int row = cell[0] + temp[0];
                int column = cell[1] + temp[1];
                if (row < 0 || row >= r || column < 0 || column >= c || matrix[row][column] <= matrix[cell[0]][cell[1]] + 1)
                    continue;
                queue.offer(new int[]{row, column});
                matrix[row][column] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        return matrix;
    }
}
