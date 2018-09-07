package com.abin.lee.algorithm.basic.array.common;

import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by abin on 2018/7/8.
 * 整形数组求出现次数最多的数字
 * https://blog.csdn.net/legend050709/article/details/26580249
 * https://www.jianshu.com/p/ac6c2b5d09dd
 */
public class AppearMaxFrequencyInArray {

    public static void main(String[] args) {
//        int[] input = {11, 11, 2, 2, 4, 5, 4, 2,2,2};
        int[] input ={1,1,2,2,4,4,4,4,5,5,6,6};
        int result1 = maxFrequence(input);
        System.out.println("result1=" + result1);
        int result2 = getMax(input);
        System.out.println("result2=" + result2);
    }

    public static Integer maxFrequence(int[] input) {
        int num = 0;
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(input[i])) {
                int temp = map.get(input[i]);
                map.put(input[i], ++temp);
            } else {
                map.put(input[i], 1);
            }
        }
        int temp = 0;
        for (Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int count = entry.getValue();
            if (count > temp) {
                temp = count;
                num = entry.getKey();
            }
        }
        return num;
    }

    public static int getMax(int[] input) {
        int curNum = 0;
        int curMax = 0;
        int max = 0;
        for (int i = 0; i <input.length-1 ; i++) {
            curNum = input[i];
            if(input[i+1] == curNum){
                ++curMax;
            }else{
                curMax = 1;
            }
            if(curMax>max)
                max = curMax;
        }
        return curNum;
    }



}
