package com.qunar.des.algorithm.sort.test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-8 下午7:48
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] input = new int[]{6, 2, 1, 3, 5, 4};
        quick(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }

    public static void quick(int[] input, int low, int high) {
        if (low < high) {
            int middle = getMiddle(input, low, high);
            quick(input, low, middle - 1);
            quick(input, middle + 1, high);
        }
    }

    public static int getMiddle(int[] input, int low, int high) {
        int temp = input[low];
        while (low < high) {
            while (low < high && input[high] > temp) {
                high--;
            }
            input[low] = input[high];
            while (low < high && input[low] < temp) {
                low++;
            }
            input[high] = input[low];
        }
        input[low] = temp;
        return low;
    }
}
