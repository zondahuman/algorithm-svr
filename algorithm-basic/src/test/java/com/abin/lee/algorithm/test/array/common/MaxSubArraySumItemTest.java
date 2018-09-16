package com.abin.lee.algorithm.test.array.common;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abin on 2018/9/16.
 */
public class MaxSubArraySumItemTest {

    public static List<Integer> maxSum(int[] array) {
        int start = 0;
        int end = 0;
        int currentStart = 0;
        int maxSum = 0;
        int currentSum = 0;
        for (int i = 0; i < array.length; i++) {
            currentSum += array[i];
            if (currentSum < 0) {
                currentStart = i;
                currentSum = 0;
            } else {
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    start = currentStart;
                    end = i;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = start + 1; i <= end; i++) {
            list.add(array[i]);
        }
        return list;
    }

    /**
     * 给定无序整数序列，求连续子串最大和，例如{-23 17 -7 11 -2 1 -34}，子串为{17,-7,11}，最大和为21
     * 输入描述:
     * 输入为整数序列，数字用空格分隔，如：-23 17 -7 11 -2 1 -34
     * 输出为子序列的最大和：21
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arrays = new int[]{-23, 17, -7, 11, -2, 1, -34};
        List<Integer> list = maxSum(arrays);
        System.out.println("list=" + JsonUtil.toJson(list));

    }
}
