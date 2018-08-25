package com.qunar.des.algorithm.leetcode.arrarer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abin on 2018/8/25.
 * 219. Contains Duplicate II
 https://leetcode.com/problems/contains-duplicate-ii/description/
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length ==0)
            return false;
        Map<Integer, Integer> request = new HashMap<Integer,Integer>();
        for (int i = 0; i <nums.length ; i++) {
            if(request.containsKey(nums[i])){
                Integer difference = i-request.get(nums[i]);
                if(difference <= k)
                    return true;
                else
                    request.put(nums[i], i);
            }else{
                request.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3,5};
        boolean result = new ContainsDuplicateII().containsNearbyDuplicate(nums, 1);
        System.out.println("result=" + result);
    }





}
