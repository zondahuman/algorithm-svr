package com.abin.lee.algorithm.special.basic.topk;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by abin on 2018/9/15.
 * Top k ,求出现次数最少的, 使用大顶堆
 */
public class TopSmallKMaxHeap {
    public static void main(String[] args) {
        int[] input = new int[]{5, 1, 3, 6, 2, 4};
        int[] param = new int[3];
        int[] result = new TopSmallKMaxHeap().topSmallK(input, 3);
        System.out.println("input=" + JsonUtil.toJson(input));
        System.out.println("result=" + JsonUtil.toJson(result));
    }

    public int[] topSmallK(int[] param, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < param.length; i++) {
            if (queue.size() < k) {
                queue.add(param[i]);
            } else {
                if (param[i] < queue.peek()) {
                    queue.poll();
                    queue.offer(param[i]);
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
//        int i = 0;
//        for (int temp :queue) {
//            result[i++] = temp;
//        }
        return result;
    }

}
