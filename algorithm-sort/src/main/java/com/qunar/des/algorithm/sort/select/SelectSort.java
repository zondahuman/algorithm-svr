package com.qunar.des.algorithm.sort.select;

import java.util.Arrays;

/**
 * Created by abin on 2018/5/31 20:13.
 * algorithm-svr
 * com.qunar.des.algorithm.sort.select
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] input = new int[]{1, 0, 4, 3, 5, 2, 6, 9, 8, 7};
        input = selectionRecursive(input, 0, input.length-1);
        System.out.println(Arrays.toString(input));
    }

    /**
     * 选择排序递归实现
     * @param data
     * @param start
     * @param end
     * @return
     * 注意问题：start ++那里，注意每次递归的起始终止下标的移动，起始每次加1，终止下标不变，
       循环结束条件 为start == end，以及i < end + 1
       https://blog.csdn.net/chenglibin1988/article/details/8946873
     */
    public static int[] selectionRecursive(int[] data, int start, int end) {
        if (start < end) {
            //int length = end - start + 1;
            int temp = data[start];
            int index = start;
            for (int i = start + 1; i < end + 1; i++) {
                if (data[index] > data[i]) {
                    index = i;
                }
            }
            if (start != index) {
                temp = data[start];
                data[start] = data[index];
                data[index] = temp;
            }
            start++;
            selectionRecursive(data, start, end);
        }
        return data;
    }


}
