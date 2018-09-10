package com.abin.lee.algorithm.leetcode.matrix;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

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
                result[i / c][i % c] = nums[i / column][i % column];
            }
            return result;
        } else {
            return nums;
        }
    }

    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        if(nums == null || nums.length==0 || nums[0].length==0)
            return new int[][]{};
        if(r*c > nums.length*nums[0].length) return nums;
        int row = nums.length;
        int column = nums[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <column ; j++) {
                queue.offer(nums[i][j]);
            }
        }
        int[][] result = new int[r][c];
        for (int i = 0; i <r ; i++) {
            for (int j = 0; j <c ; j++) {
                result[i][j] = queue.poll();
            }
        }
        return result;
    }

    /**
     * 这个官方的解答有错误，请注意************************
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape3(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        Queue < Integer > queue = new LinkedList < > ();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                queue.add(nums[i][j]);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = queue.remove();
            }
        }
        return res;
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
//        int[][] result = new ReshapeTheMatrix().matrixReshape(params, 1, 4);
        int[][] result = new ReshapeTheMatrix().matrixReshape2(params, 1, 4);
        System.out.println("result=" + JsonUtil.toJson(result));
    }


    @Test
    public void test(){
        System.out.println(0/2);
        System.out.println(1/2);
        System.out.println(2/2);
        System.out.println(3/2);
    }

}
