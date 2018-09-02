package com.abin.lee.algorithm.sort.bubble;

import java.util.Arrays;

/**
 * 冒泡排序时间复杂度为O（n^2）
 * N个数字要排序完成，总共进行N-1趟排序，每i趟的排序次数为(N-i)次，所以可以用双重循环语句，外层控制循环多少趟，内层控制每一趟的循环次数
 * https://www.cnblogs.com/shen-hua/p/5422676.html
 */
public class BubbleSort {

    /**
     * 冒泡算法循环实现
     * @param input
     * @return
     */
    public static int[] bubbleLoop(int[] input) {
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

    /**
     * 冒泡算法递归实现
     * @param input
     * @param start
     * @param end
     *
     *  注意问题：end--那里，注意每次递归的起始终止下标的移动，起始下标不变，终止下标每次减1，
     *  循环结束条件 为start == end，以及i < length - 1;
     *  https://blog.csdn.net/chenglibin1988/article/details/8946873
     */
    public static int[] bubbleRecursive(int[] input, int start, int end) {
        if (start < end) {
            int temp = 0;
            int length = end - start + 1;
            for (int i = start; i < length - 1; i++) {
                if (input[i] > input[i + 1]) {
                    temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                }
            }
            end--;
            bubbleRecursive(input, start, end);
        }
        return input;
    }




    public static void main(String[] args) {
        int[] input = new int[]{1, 0, 4, 3, 5, 2, 6, 9, 8, 7};
//        input = bubbleLoop(input);
//        System.out.println(Arrays.toString(input));
        input = bubbleRecursive(input, 0, input.length-1);
        System.out.println(Arrays.toString(input));
    }

}
