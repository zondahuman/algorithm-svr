package com.abin.lee.algorithm.leetcode.arrarer;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by abin on 2018/8/25.
 * 220. Contains Duplicate III
 * https://leetcode.com/problems/contains-duplicate-iii/description/
 * https://blog.csdn.net/xudli/article/details/46323247
 *
 */
public class ContainsDuplicateIII {

    /**
     * num[i]-num[j]<=t
     * i-j<=t
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //input check
        if(k<1 || t<0 || nums==null || nums.length<2) return false;

        SortedSet<Long> set = new TreeSet<Long>();

        for(int j=0; j<nums.length; j++) {
            SortedSet<Long> subSet =  set.subSet((long)nums[j]-t, (long)nums[j]+t+1);
            if(!subSet.isEmpty()) return true;

            if(j>=k) {
                set.remove((long)nums[j-k]);
            }
            set.add((long)nums[j]);
        }
        return false;

    }

    /**
     * num[i]-num[j]<=t
     * i-j<=t
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k, int t) {
        if(nums==null || nums.length ==0 || k<1 || t<0)
            return false;
        SortedSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i <nums.length ; i++) {
            SortedSet<Long> sortSet = set.subSet((long)nums[i]-t, (long)nums[i]+t+1);
            if(!sortSet.isEmpty())
                return true;
            if(i>=k)
                set.remove((long)nums[i-k]);
            set.add((long)nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3,5};
        boolean result = new ContainsDuplicateII().containsNearbyDuplicate(nums, 1);
        System.out.println("result=" + result);
    }



}
