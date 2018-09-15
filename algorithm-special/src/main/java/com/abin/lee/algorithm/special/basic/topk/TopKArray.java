package com.abin.lee.algorithm.special.basic.topk;

/**
 * Created by abin on 2018/9/15.
 * top k算法讲解
 * https://blog.csdn.net/dingpiao190/article/details/73604718
 */
public class TopKArray {

    private final int MAXSIZE = 10 + 1;
    private int currentSize = 1;

    private void heap_insert(int[] array, int value) {

        if (currentSize < MAXSIZE) {
            array[currentSize++] = value;
            if (currentSize == MAXSIZE) {
                for (int i = currentSize / 2; i > 0; i--) {
                    heap_adjust(array, i, currentSize);
                }
            }
        } else {
            int max = array[1];
            if (value < max) {
                array[1] = value;
                heap_adjust(array, 1, currentSize);
            }
        }
    }

    // 堆调整
    private void heap_adjust(int[] array, int s, int len) {
        int temp = array[s];
        for (int i = 2 * s; i < len; i *= 2) {
            if (i < len - 1 && array[i] < array[i + 1])
                i++;
            if (array[i] <= temp)
                break;
            array[s] = array[i];
            s = i;
        }
        array[s] = temp;

    }


}
