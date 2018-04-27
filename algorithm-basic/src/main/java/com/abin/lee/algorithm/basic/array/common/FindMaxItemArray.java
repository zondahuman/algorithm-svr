package com.abin.lee.algorithm.basic.array.common;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/4/27 1:00.
 * algorithm-svr
 * com.abin.lee.algorithm.basic.array.common
 * 查找数组里面最大的值
 */
public class FindMaxItemArray {
    public static void main(String[] args) {
        int[] params = new int[]{1, 2, 3, 4, 5, 10};
        int result = findMaxItem(params);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

    public static int findMaxItem(int[] params){
        int current = 0;
        int max = 0;
        for (int i = 0; i <params.length ; i++) {
            current = params[i];
            if(current > max)
                max = current;
        }
        return max;
    }
}
