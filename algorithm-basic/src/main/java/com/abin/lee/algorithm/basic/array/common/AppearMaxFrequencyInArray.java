package com.abin.lee.algorithm.basic.array.common;

import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by abin on 2018/7/8.
 * https://blog.csdn.net/legend050709/article/details/26580249
 *
 */
public class AppearMaxFrequencyInArray {


    public static void main(String[] args) {
        int[] input = { 11, 11, 2, 2, 4, 5, 4, 2 };
        int result1 = maxFrequence(input);
        System.out.println("result1=" + result1);
    }


    public static Integer maxFrequence(int[] input) {
        int num = 0;
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < input.length; i++) {
            if(map.containsKey(input[i])){
                int temp = map.get(input[i]);
                map.put(input[i], ++temp);
            }else{
                map.put(input[i], 1);
            }
        }
        int temp = 0;
        for (Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int count = entry.getValue() ;
            if(count > temp) {
                temp = count;
                num = entry.getKey();
            }
        }
        return num;
    }

    public static int getMax(int[] input){




        return  0;
    }



}
