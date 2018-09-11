package com.abin.lee.algorithm.leetcode.arrarer;

/**
 * Created by abin on 2018/9/11.
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * https://blog.csdn.net/mupengfei6688/article/details/78665454
 * 在旋转排序数组中搜索
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int middle = (start + end) / 2;

            if (nums[middle] == target) {
                return middle;
            }
            if (nums[start] <= nums[middle]) {
                if (nums[start] <= target && target < nums[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
            if (nums[middle] <= nums[end]) {
                if (nums[middle] < target && target <= nums[end]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (nums[mid] <= nums[high]) {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * Example 1:
     * <p>
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     * <p>
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] param = new int[]{4, 5, 6, 7, 0, 1, 2};
        Integer result = new SearchInRotatedSortedArray().search(param, 0);
//        Integer result = new SearchInRotatedSortedArray().search2(param, 0);
        System.out.println("result=" + result);
    }


}
