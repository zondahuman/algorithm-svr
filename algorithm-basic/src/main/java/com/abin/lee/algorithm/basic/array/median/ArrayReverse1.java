package com.abin.lee.algorithm.basic.array.median;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2017/11/22 2017/11/22.
 * algorithm-svr
 * com.qunar.des.algorithm.basic.array.median
 */
public class ArrayReverse1 {

    public static void main(String[] args) {
        String input = "abcdef";
        String result = reverse(input);
        System.out.println(result);
    }
    public static String reverse(String param) {
       char[] arr = param.toCharArray();
        for (int i = 0; i <arr.length/2 ; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
        System.out.println("-----------"+ JsonUtil.toJson(arr));
        return String.valueOf(arr);
    }

}
