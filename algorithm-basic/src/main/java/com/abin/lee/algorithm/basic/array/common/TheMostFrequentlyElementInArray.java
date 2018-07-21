package com.abin.lee.algorithm.basic.array.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by abin on 2018/7/21.
 * 数组中出现次数最多的元素
 * 数组中重复次数最多的元素
 * https://blog.csdn.net/u014473112/article/details/54176803
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/description/
 */
public class TheMostFrequentlyElementInArray {


    public static void main(String[] args) {
        int[] arrays = new int[]{1,3,5,2,4,3,5,6,4,3,2,1};
        int dpResult = frequence(arrays);
        System.out.println("dpResult=" + dpResult);
    }

    public static int frequence(int[] params) {
        int max = 0;
        int index = 0;
        if (params == null || params.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < params.length; i++) {
            if (map.containsKey(params[i])) {
                map.put(params[i], map.get(params[i]) + 1);
            } else {
                map.put(params[i], 1);
            }
            if (map.get(params[i]) > max) {
                max = map.get(params[i]);
                index = params[i];
            }
        }
        return index;
    }

    public int majorityElement(int[] nums) {
        int num = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                int temp = map.get(nums[i]);
                map.put(nums[i], ++temp);
            }else{
                map.put(nums[i], 1);
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

    public int majorityElement1(int[] nums) {
        int max = 0;
        int index = 0;
        if (nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            if (map.get(nums[i]) > max) {
                max = map.get(nums[i]);
                index = nums[i];
            }
        }
        return index;
    }


}
