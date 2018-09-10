package com.abin.lee.algorithm.leetcode.matrix;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/9/11.
 * 598. Range Addition II
 * https://leetcode.com/problems/range-addition-ii/description/
 */
public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }

    public int maxCount2(int m, int n, int[][] ops) {
        int[][] result = new int[m][n];
        for (int[] op : ops) {
            for (int i = 0; i <op[0] ; i++) {
                for (int j = 0; j <op[1] ; j++) {
                    result[i][j] += 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i <result.length ; i++) {
            for (int j = 0; j <result[0].length ; j++) {
                if(result[i][j]==result[0][0]){
                    count++;
                }
            }
        }
        return count;
    }

    public int maxCount3(int m, int n, int[][] ops) {
        for(int i=0;i<ops.length;i++){
            if(ops[i][0]<m) m=ops[i][0];
            if(ops[i][1]<n) n=ops[i][1];
        }
        return m*n;
    }
    /**
     * Example 1:
     * Input:
     * m = 3, n = 3
     * operations = [[2,2],[3,3]]
     * Output: 4
     * Explanation:
     * Initially, M =
     * [[0, 0, 0],
     * [0, 0, 0],
     * [0, 0, 0]]
     * <p>
     * After performing [2,2], M =
     * [[1, 1, 0],
     * [1, 1, 0],
     * [0, 0, 0]]
     * <p>
     * After performing [3,3], M =
     * [[2, 2, 1],
     * [2, 2, 1],
     * [1, 1, 1]]
     * <p>
     * So the maximum integer in M is 2, and there are four of it in M. So return 4.
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] params = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},
        };
//        int[][] params = {
//                {1, 0},
//                {1, 1},
//        };
//        int[][] result = new ImageSmoother().imageSmoother(params);
        int[][] result = new ImageSmoother().imageSmoother(params);
        System.out.println("result=" + JsonUtil.toJson(result));
    }


}
