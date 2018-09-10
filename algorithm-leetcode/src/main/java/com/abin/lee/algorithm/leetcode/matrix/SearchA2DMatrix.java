package com.abin.lee.algorithm.leetcode.matrix;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/9/10.
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 * https://leetcode.com/problems/search-a-2d-matrix/discuss/26292/Java-clear-solution
 * https://leetcode.com/problems/search-a-2d-matrix/discuss/26215/An-Easy-Solution-in-Java
 */
public class SearchA2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},
        };
//        boolean result = new SearchA2DMatrix().searchMatrix(matrix, 3);
//        boolean result = new SearchA2DMatrix().searchMatrix(matrix, 13);
        boolean result = new SearchA2DMatrix().searchMatrix(new int[][]{}, 1);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int r = 0;
        int c = matrix[0].length - 1;
        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }


}
