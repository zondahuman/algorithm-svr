package com.abin.lee.algorithm.special.basic.maze;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/5/30 15:49.
 * algorithm-svr
 * com.abin.lee.algorithm.special.basic.maze
 * 获取二维数组的相邻元素
 * Java二维数组的概念和使用方法: https://www.cnblogs.com/zhouguanglin/p/7210129.html
 */
public class AdjacentTwoDimensionalArray {

    public static void main(String[] args) {
        int[][] result1 = create1();
        for (int i = 0; i <result1.length ; i++) {
            System.out.println(JsonUtil.toJson(result1[i]) + "");
        }
//        System.out.println("result1=" + JsonUtil.toJson(result1));
    }

    public static int[][] adj() {
        int[][] directory = {{-1, -1,}, {-1, 0,}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        return directory;
    }

    public static int[][] create() {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) { //遍历二维数组，遍历出来的每一个元素是一个一维数组
            for (int j = 0; j < arr[i].length; j++) { //遍历对应位置上的一维数组
                System.out.println(arr[i][j]);
            }
        }
        return arr;
    }

    public static int[][] create1() {
        int[][] arr3 = new int[5][];//五行的长度
        for (int i = 0; i < arr3.length; ++i) {
            arr3[i] = new int[5];   //列的长度每次都变化。每次都要重新申请空间(长度)
            for (int j = 0; j < arr3[i].length; ++j)
                arr3[i][j] = i + j;
        }
        return arr3;
    }
}
