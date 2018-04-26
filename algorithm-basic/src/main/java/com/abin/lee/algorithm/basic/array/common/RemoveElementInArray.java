package com.abin.lee.algorithm.basic.array.common;

/**
 * Created by abin on 2018/4/27 1:00.
 * algorithm-svr
 * com.abin.lee.algorithm.basic.array.common
 * 删除指定数组的元素
 * https://blog.csdn.net/zsy112371/article/details/52416816
 */
public class RemoveElementInArray {
    public static void main(String[] args) {
        int params[]={1, 2, -4, 3, 2, -5, 3};
        int result = removeElement(params, 3);
        System.out.println("result=" + result);
    }

    public static int removeElement(int[] params, int k){
        if(null == params || params.length == 0)
            return 0;
        int m = 0;
        for (int i = 0; i <params.length ; i++) {
            if(params[i] != k){
                params[m] = params[i];
                m++;
            }
        }
        return m;
    }
}
