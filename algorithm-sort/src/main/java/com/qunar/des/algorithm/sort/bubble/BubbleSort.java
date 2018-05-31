package com.qunar.des.algorithm.sort.bubble;

import java.util.Arrays;

/**
 * 冒泡排序时间复杂度为O（n^2）
 * N个数字要排序完成，总共进行N-1趟排序，每i趟的排序次数为(N-i)次，所以可以用双重循环语句，外层控制循环多少趟，内层控制每一趟的循环次数
 * https://www.cnblogs.com/shen-hua/p/5422676.html
 */
public class BubbleSort {
    public static int[] bubble(int[] input) {
        int temp = 0;
        for (int i = 0; i < input.length - 1; i++) { //外层循环控制排序趟数
            for (int j = 0; j < input.length - i - 1; j++) { //内层循环控制每一趟排序多少次
                if (input[j] > input[j + 1]) {
                    temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
        return input;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 0, 4, 3, 5, 2, 6, 9, 8, 7};
        input = bubble(input);
        System.out.println(Arrays.toString(input));
    }

}
