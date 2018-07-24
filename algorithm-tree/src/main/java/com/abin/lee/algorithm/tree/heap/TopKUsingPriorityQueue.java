package com.abin.lee.algorithm.tree.heap;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by abin on 2018/7/24.
 * Top K问题的两种解决思路
 * https://www.cnblogs.com/en-heng/p/6336625.html
 * https://blog.csdn.net/x_i_y_u_e/article/details/50931172
 */
public class TopKUsingPriorityQueue {

    public static void main(String[] args) {

    }

    @Test
    public void testSetTopK() {
        int k = 3;
        int[] input = new int[7];
        for (int i = 0; i < 7; i++) {
            input[i] = i;
        }
        for (int i = 0; i < input.length; i++) {
            Integer[] result = setTopK(input, k);
            System.out.println("result=" + JsonUtil.toJson(result));
        }
    }

    public static Integer[] setTopK(int[] arrays, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for (Integer temp : arrays) {
            if (priorityQueue.size() < k || priorityQueue.peek() < temp)
                priorityQueue.offer(temp);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.toArray(new Integer[]{});
    }


    @Test
    public void testSelectMax() {
        int k = 3;
        int[] input = new int[7];
        for (int i = 0; i < 7; i++) {
            input[i] = i;
        }
        int[] result = selectMax(input, k);
        System.out.println("result=" + JsonUtil.toJson(result));
    }


    public int[] selectMax(int[] array, int k) {
        int[] res = new int[k];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < array.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(array[i]);
            } else {
                int maxQueue = priorityQueue.peek();
                if (maxQueue < array[i]) {
                    priorityQueue.poll();
                    priorityQueue.offer(array[i]);
                }
            }
        }

        for (int i = 0; i < k; i++) {
            res[k - i - 1] = priorityQueue.poll();
        }
        return res;

    }


}
