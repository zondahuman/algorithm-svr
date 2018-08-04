package com.qunar.des.algorithm.leetcode.arrarer;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abin on 2018/8/3.
 * 167. Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            if (!map.containsKey(temp)) {
                map.put(numbers[i], i);
            } else {
                int another = numbers[i];
                if (temp > another)
                    return new int[]{i + 1, map.get(temp) + 1};
                else
                    return new int[]{map.get(temp) + 1, i + 1};
            }
        }
        return new int[2];
    }

    public int[] twoSum1(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;
        while(i<j){
            int sum = numbers[i] + numbers[j];
            if(sum == target)
                return new int[]{i+1, j+1};
            else if( sum < target){
                i++;
            }else{
                j--;
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 7, 11, 15};
//        int[] list = new TwoSumII().twoSum(input, 9);
        int[] list = new TwoSumII().twoSum1(input, 9);
        System.out.println("list=" + JsonUtil.toJson(list));
    }


}
