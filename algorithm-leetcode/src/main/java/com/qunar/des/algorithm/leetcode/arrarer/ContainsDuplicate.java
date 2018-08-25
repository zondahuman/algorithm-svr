package com.qunar.des.algorithm.leetcode.arrarer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by abin on 2018/7/30.
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/description/
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums != null && nums.length > 0) {
            Set<Integer> set = new HashSet<Integer>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                if(set.contains(nums[i])){
                    return true;
                }else{
                    set.add(nums[i]);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        boolean result = new ContainsDuplicate().containsDuplicate(nums);
        System.out.println("result=" + result);
    }


}
