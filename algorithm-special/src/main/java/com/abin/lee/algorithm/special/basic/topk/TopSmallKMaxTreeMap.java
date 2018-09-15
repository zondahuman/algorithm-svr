package com.abin.lee.algorithm.special.basic.topk;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Top k ,求出现次数最小的, 使用TreeMap的从大到小排序，需要传入构造器Comparator，按照从大到小排序
 */

public class TopSmallKMaxTreeMap {
    public static int[] topSmallK(int param[], int k) {
        TreeSet<Integer> topSet = new TreeSet<>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < param.length; i++) {
            if (topSet.size() < k) {
                topSet.add(param[i]);
            } else {
                if (topSet.first() > param[i]) {
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
        int[] result = new TopSmallKMaxTreeMap().topSmallK(input, 3);
        System.out.println("input=" + JsonUtil.toJson(input));
        System.out.println("result=" + JsonUtil.toJson(result));
    }
}