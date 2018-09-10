package com.abin.lee.algorithm.leetcode.matrix;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/9/10.
 * 832. Flipping an Image
 * 翻转图像
 * https://leetcode.com/problems/flipping-an-image/description/
 */
public class FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int column = A[0].length;
        int[][] result = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = column - 1; j >= 0; j--) {
                result[i][column - 1 - j] = A[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (result[i][j] == 0) {
                    result[i][j] = 1;
                }else if(result[i][j] == 1) {
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }

    /**
     * Example 1:
     * <p>
     * Input: [[1,1,0],[1,0,1],[0,0,0]]
     * Output: [[1,0,0],[0,1,0],[1,1,1]]
     * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
     * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
     * Example 2:
     * <p>
     * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
     * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
     * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] params = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0},
        };
//        int[][] params = {
//                {1, 0},
//                {1, 1},
//        };
        int[][] result = new FlippingAnImage().flipAndInvertImage(params);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

}
