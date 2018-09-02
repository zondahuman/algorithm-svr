package com.abin.lee.algorithm.leetcode.arrarer;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/7/9.
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("nums=" + JsonUtil.toJson(nums));
        int result = removeDuplicates(nums);
        System.out.println("nums=" + JsonUtil.toJson(nums));
        System.out.println("result=" + result);

    }

    public static int removeDuplicates(int[] nums) {
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[result] != nums[i]) {
                ++result;
                nums[result] = nums[i];
            }
        }
        return result+1;
    }


}
