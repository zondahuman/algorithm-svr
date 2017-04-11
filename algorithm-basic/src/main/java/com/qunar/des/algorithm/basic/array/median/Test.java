package com.qunar.des.algorithm.basic.array.median;

import java.util.Arrays;

/**
 * 创建人：subin.li
 * 创建时间：2014年11月30日 下午4:26:19
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        inverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] inverse(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - i - 1; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }

}
