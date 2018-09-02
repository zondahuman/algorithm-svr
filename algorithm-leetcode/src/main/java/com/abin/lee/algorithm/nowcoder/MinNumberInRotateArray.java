package com.abin.lee.algorithm.nowcoder;

/**
 * Created by abin on 2018/7/18.
 */
public class MinNumberInRotateArray {
    public static void main(String[] args) {
        int[] param = {3, 4, 5, 1, 2};
        int result = new MinNumberInRotateArray().minNumberInRotateArray(param);
        System.out.println("result=" + result);
    }

    public int minNumberInRotateArray(int[] array) {
        int one = array[0];
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            if (i + 1 < array.length) {
                if (array[i] >= one && array[i] > array[i + 1]) {
                    temp = array[i + 1];
                }
            }
        }
        return temp;
    }
}
