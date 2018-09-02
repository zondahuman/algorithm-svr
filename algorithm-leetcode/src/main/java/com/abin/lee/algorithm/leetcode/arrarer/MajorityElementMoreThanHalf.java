package com.abin.lee.algorithm.leetcode.arrarer;

/**
 * Created by abin on 2018/7/8.
 * Leetcode：169. Majority Element（找到数组中出现次数最多的元素）
 * https://blog.csdn.net/dashenxueba/article/details/78708147
 * https://leetcode.com/problems/majority-element/description/
 */
public class MajorityElementMoreThanHalf {
    public static void main(String[] args) {
//        int[] input = {11, 11, 2, 2, 4, 5, 4, 2,2,2};
        int[] input = {1, 2, 2};
        int result2 = majorityElement(input);
        System.out.println("result2=" + result2);
    }

    public static int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (major == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

}
