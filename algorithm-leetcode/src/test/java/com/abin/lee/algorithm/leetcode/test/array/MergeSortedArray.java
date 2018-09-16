package com.abin.lee.algorithm.leetcode.test.array;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/9/16.
 */
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while (len2 >= 0) {
            nums1[len--] = (len1 >= 0 && nums1[len1] > nums2[len2]) ? nums1[len1--] : nums2[len2--];

        }
    }

    /**
     * Example:
     * <p>
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * Output: [1,2,2,3,5,6]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
//        merge(nums1, nums1.length-nums2.length, nums2, nums2.length);
        merge(nums1, m, nums2, n);
        System.out.println("nums1=" + JsonUtil.toJson(nums1));
    }


}
