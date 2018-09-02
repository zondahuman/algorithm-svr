package com.abin.lee.algorithm.leetcode.arrarer;

/**
 * Created by abin on 2018/7/30.
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/description/
 */
public class RemoveElement27 {

    public int removeElement(int[] nums, int val) {
        int result = nums.length;
        int i = 0;
        while (i < result) {
            if (nums[i] == val) {
                nums[i] = nums[result - 1];
                result--;
            }else{
                i++;
            }
        }
        return result;
    }

    /**
     * Given nums = [0,1,2,2,3,0,4,2], val = 2,
     * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int result = new RemoveElement27().removeElement(nums, val);
        System.out.println("result=" + result);
    }
}
