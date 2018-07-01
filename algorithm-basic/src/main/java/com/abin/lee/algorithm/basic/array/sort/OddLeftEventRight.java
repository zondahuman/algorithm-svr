package com.abin.lee.algorithm.basic.array.sort;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/7/1.
 * 能实现把一个数组元素中的奇数放左边，偶数放右边
 */
public class OddLeftEventRight {

    public static void main(String[] args) {
        int[] params = new int[]{1, 2, 3, 4, 5, 10};
        srotArray(params);
        System.out.println("params=" + JsonUtil.toJson(params));
    }

    public static void srotArray(int[] params){
        int start = 0;
        int end = params.length-1;
        while (start < end) {
            while (params[start] % 2 == 1 && start < end) {
                start++;
            }
            while (params[end] % 2 == 0 && start < end) {
                end--;
            }
            int temp = 0;
            temp = params[start];
            params[start] = params[end];
            params[end] = temp;
        }
    }

}
