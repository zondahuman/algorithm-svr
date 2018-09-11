package com.abin.lee.algorithm.leetcode.arrarer;

/**
 * Created by abin on 2018/9/11.
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/description/
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i])
                return i;
            if (i - 1 > 0 && target > nums[i - 1] && target < nums[i]) {
                return i - 1;
            }
            if(target > nums[nums.length-1]){
                return nums.length;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] param = new int[]{1, 3, 5, 6};
        Integer result = new SearchInsertPosition().searchInsert(param, 7);
//        Integer result = new SearchInsertPosition().searchInsert(param, 0);
        System.out.println("result=" + result);
    }

}
