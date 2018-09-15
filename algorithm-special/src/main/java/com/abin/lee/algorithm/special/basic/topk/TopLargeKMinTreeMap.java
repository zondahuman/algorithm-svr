package com.abin.lee.algorithm.special.basic.topk;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.TreeSet;

/**
 * Top k ,求出现次数最多的, 使用TreeMap的从小到大排序，TreeMap默认如果传入数值的话，是按照从小到大排序，如果传入的是字典的话，是按照字典序排序
 */

public class TopLargeKMinTreeMap {
    public static int[] toplargeK(int param[], int k) {
        TreeSet<Integer> topSet = new TreeSet<>();
        for (int i = 0; i < param.length; i++) {
            if (topSet.size() < k) {
                topSet.add(param[i]);
            } else {
                if (topSet.first() < param[i]) {
                    topSet.pollFirst();
                    topSet.add(param[i]);
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topSet.pollFirst();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{5, 1, 3, 6, 2, 4};
        int[] param = new int[3];
        int[] result = new TopLargeKMinTreeMap().toplargeK(input, 3);
        System.out.println("input=" + JsonUtil.toJson(input));
        System.out.println("result=" + JsonUtil.toJson(result));
    }
}