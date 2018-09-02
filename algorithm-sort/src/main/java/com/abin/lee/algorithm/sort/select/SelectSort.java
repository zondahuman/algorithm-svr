package com.abin.lee.algorithm.sort.select;

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
//        input = selectionLoop(input);
//        System.out.println(Arrays.toString(input));
    }
    public static int[] selectionLoop(int[] params) {
        for (int i = 0; i < params.length; i++) {
            for (int j = i+1; j < params.length; j++) {
                if(params[i] > params[j]){
                    int temp = params[i] ;
                    params[i] = params[j] ;
                    params[j] = temp ;
                }
            }
        }
        return params ;
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

    /**
     * 冒泡排序：

     冒泡排序（BubbleSort）的基本概念是：依次比较相邻的两个数，将小数放在前面，大数放在后面。即在第一趟：首先比较第1个和第2个数，将小数放前，大数 放后。

     然后比较第2个数和第3个数，将小数放前，大数放后，如此继续，直至比较最后两个数，将小数放前，大数放后。至此第一趟结束，将最大的数放到了最后。

     在第二趟：仍从第一对数开始比较（因为可能由于第2个数和第3个数的交换，使得第1个数不再小于第2个数），将小数放前中，大数放后，一直比较到倒数第二个数（倒数第一的位置上已经是最大的），第二趟结束，在倒数第二的位置上得到一个新的最大数（其实在整个数列中是第二大的数）。如此下去，重复以上过程，直至最终完成排序。

     选择排序

     第一次从下标为0的开始下标为0的这个数与后面的n-1个进行比较；找出最小或者最大的放在下标为0的这个位置；第二次从下标为1的开始比较；查询剩下的最大或者最小值；放在下标为1的位置；以此类推；直到排序完成。
     */


}
