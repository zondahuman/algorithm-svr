package com.abin.lee.algorithm.leetcode.matrix;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/9/10.
 * 566. Reshape the Matrix
 * 重塑矩阵
 * https://leetcode.com/problems/reshape-the-matrix/description/
 * https://blog.csdn.net/my_lovely_lemon_tree/article/details/71023703
 */
public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int column = nums[0].length;
        int[][] result = new int[r][c];
        //2*2 = 1*4
        if (row * column == r * c) {
            for (int i = 0; i < r * c; i++) {
                result[i / c][i % c] = nums[i / column][i / column];
            }
        } else {
            return nums;
        }
        return result;
    }

    /**
     * （1）origin_r * origin_c 的矩阵 reshape为 r*c的矩阵，需要满足：
     * origin_r * origin_c=r*c
     * （2）元素位置对应的关系
     * 如果将矩阵横向展开为一维数组，元素个数为n=origin_r * origin_c
     * 在元素在一维数组中对应的位置i：
     * 原矩阵位置[i/origin_c,i%origin_c]
     * 新矩阵位置[i/c,i%c]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] params = {
                {1, 2},
                {3, 4},
        };
//        int[][] params = {
//                {1, 0},
//                {1, 1},
//        };
//        int[][] result = new ReshapeTheMatrix().matrixReshape(params);
        int[][] result = new ReshapeTheMatrix().matrixReshape(params, 1, 3);
        System.out.println("result=" + JsonUtil.toJson(result));
    }


}
