package com.abin.lee.algorithm.leetcode.arrarer;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/7/16.
 * https://blog.csdn.net/whdAlive/article/details/80379984
 * 合并两个有序数组
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/description/
 */
public class MergeSortedArray {
    /**
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * 说明:
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * Output: [1,2,2,3,5,6]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, nums1.length-nums2.length, nums2, nums2.length);
        System.out.println("nums1=" + JsonUtil.toJson(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while (len2 >= 0) {
            nums1[len--] = (len1 >= 0 && nums1[len1] > nums2[len2]) ? nums1[len1--] : nums2[len2--];
        }
    }



}
