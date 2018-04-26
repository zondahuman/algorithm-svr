package com.abin.lee.algorithm.basic.array.common;

import com.google.common.collect.Maps;
import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abin on 2018/4/26 12:16.
 * algorithm-svr
 * com.abin.lee.algorithm.basic.array.common
 * 寻找和为定值的两个数
 * 找出数组里面任意两个数相加等于一个值k？
 * 找出数组里面任意两个数相加等于某个k值(假设数组中存在这样的两个数)
 */
public class AnyTwoNumArrayAddEqualsK {
    public static void main(String[] args) {
        int[] params = new int[]{1, 2, 3, 4, 5, 10};
//        int[] flag = findTwoNumSumEqualsK(params, 11);
//        int[] flag = findTwoNumSumEqualsK2(params, 11);
        int[] flag = findTwoNumPlusK(params, 11);
        System.out.println("flag=" + JsonUtil.toJson(flag));
    }

    /**
     * 数组是否有序不确定,数组不能有相同的数字
     * 我来个O(n)的方法。
     * 遍历数组。
     * 对于一个元素x，先把它丢进哈希表。
     * 然后在哈希表中找k-x。命中就出解。
     *
     * @param params
     * @param k
     * @return
     */
    public static int[] findTwoNumSumEqualsK(int[] params, int k) {
        Map<Integer, Integer> hashs = Maps.newHashMap();
        for (int i = 0; i < params.length; i++) {
            if (hashs.containsKey(k - params[i])) {
                return new int[]{hashs.get(k - params[i]), i};
            } else {
                hashs.put(params[i], i);
            }
        }
        return null;
    }

    public static int[] findTwoNumSumEqualsK2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer pos = map.get(target - nums[i]);
            if (pos != null) {
                int[] pair = new int[2];
                pair[0] = pos;
                pair[1] = i;
                return pair;
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 已知数组是从小到大有序的
     * @return
     */
    public static int[] findTwoNumPlusK(int[] params, int k) {
        int start = 0;
        int end = params.length-1;
        while(start < end){
            if(params[start] + params[end] == k){
                return new int[]{start, end};
            }else{
                if(params[start] + params[end] > k){
                    end--;
                }
                if(params[start] + params[end] < k){
                    start++;
                }
            }
        }
        return new int[0];
    }

}
