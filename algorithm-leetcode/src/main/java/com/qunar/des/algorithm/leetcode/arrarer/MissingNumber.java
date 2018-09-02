package com.qunar.des.algorithm.leetcode.arrarer;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by abin on 2018/8/3.
 * 268. Missing Number
 * https://leetcode.com/problems/missing-number/description/
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i <nums.length+1 ; i++) {
            if(!set.contains(i))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        int list = new MissingNumber().missingNumber(input);
        System.out.println("list=" + JsonUtil.toJson(list));
    }


}
