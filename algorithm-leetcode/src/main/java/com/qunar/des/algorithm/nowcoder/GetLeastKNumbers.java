package com.qunar.des.algorithm.nowcoder;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abin on 2018/7/19.
 * 最小的K个数
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastKNumbers {
    public static void main(String[] args) {
        int[] param = {1, -2, 3, 10, -4, 7, 2, -5};
        ArrayList<Integer> result = new GetLeastKNumbers().GetLeastNumbers_Solution(param, 4);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (input == null || input.length == 0)
            return list;
        if (input.length < k || k == 0)
            return list;
        for (int i = 0; i < k; i++)
            list.add(input[i]);
        for (int i = k; i < input.length; i++) {
            int j = getMax(list);
            int temp = list.get(j);
            if(input[i] < temp)
                list.set(j, input[i]);
        }
        return list;
    }

    public int getMax(List<Integer> list) {
        int max = list.get(0);
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                j = i;
            }
        }
        return j;
    }


}
