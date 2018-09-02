package com.abin.lee.algorithm.nowcoder;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/7/18.
 * 调整数组顺序使奇数位于偶数前面
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class OddLeftEventRight {
    public static void main(String[] args) {
        int[] param = {3, 4, 5, 1, 2};
//        int result = new OddLeftEventRight().reOrderArray(param);
        new OddLeftEventRight().reOrderArray(param);
        System.out.println("param=" + JsonUtil.toJson(param));
    }

    public void reOrderArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            while (array[start] % 2 == 1 && start < end) {
                start++;
            }
            if (array[end] % 2 == 0 && start < end) {
                end--;
            }
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }

    }


}
