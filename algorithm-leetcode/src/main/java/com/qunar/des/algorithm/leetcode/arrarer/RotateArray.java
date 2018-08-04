package com.qunar.des.algorithm.leetcode.arrarer;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

import java.util.Arrays;

/**
 * Created by abin on 2018/8/4.
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/description/
 * https://blog.csdn.net/wang424313682/article/details/52234849
 * https://segmentfault.com/a/1190000007002988
 */
public class RotateArray {

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k == 0)
            return;
        int[] temp = Arrays.copyOfRange(nums, 0, n - k);
        System.arraycopy(nums, n-k, nums, 0, k);
        System.arraycopy(temp, 0, nums, k, n-k);
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1)
            return;
        k %= nums.length;
        if (k == 0)
            return;
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }

    public void swap(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7};
//        new RotateArray().rotate(input, 3);
        new RotateArray().rotate2(input, 3);
        System.out.println("input=" + JsonUtil.toJson(input));
    }
}
