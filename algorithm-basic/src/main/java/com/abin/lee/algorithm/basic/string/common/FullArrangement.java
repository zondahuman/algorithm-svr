package com.abin.lee.algorithm.basic.string.common;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abin on 2018/5/12 13:52.
 * algorithm-svr
 * com.abin.lee.algorithm.basic.string.common
 * 全排列
 * https://leetcode.com/problems/permutations/description/
 * https://leetcode.com/problems/permutations/discuss/18470/My-Java-Accepted-solution-without-additional-space
 * https://blog.csdn.net/bitcarmanlee/article/details/51558272
 */
public class FullArrangement {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        List<List<Integer>> list = new FullArrangement().permute(nums);
        System.out.println("list=" + JsonUtil.toJson(list));
    }

    public List<List<Integer>> permute(int[] nums) {
        if (null == nums)
            return null;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        permute(list, nums, 0);
        return list;
    }

    public List<List<Integer>> permute(List<List<Integer>> list, int[] nums, int start) {
        int end = nums.length;
        if (start >= end) {
            List<Integer> current = new ArrayList<Integer>();
            for (int temp : nums) {
                current.add(temp);
            }
            list.add(current);
        } else {
            for (int i = start; i < end; i++) {
                swap(nums, start, i);
                permute(list, nums, start + 1);
                swap(nums, start, i);
            }
        }

        return null;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
