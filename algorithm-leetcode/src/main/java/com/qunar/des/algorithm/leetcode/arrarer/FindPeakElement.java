package com.qunar.des.algorithm.leetcode.arrarer;

/**
 * Created by abin on 2018/8/26.
 * 162. Find Peak Element
 * [LeetCode] Find Peak Element 求数组的局部峰值
 https://www.cnblogs.com/aksdenjoy/p/5800420.html
 https://www.cnblogs.com/grandyang/p/4217175.html
 https://leetcode.com/problems/find-peak-element/description/
 */
public class FindPeakElement {
    /**
     * Input: nums = [1,2,3,1]
     Output: 2
     Explanation: 3 is a peak element and your function should return the index number 2.

     Input: nums = [1,2,1,3,5,6,4]
     Output: 1 or 5
     Explanation: Your function can return either index number 1 where the peak element is 2,
     or index number 5 where the peak element is 6.
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int start = 0 ;
        int end = nums.length-1 ;
        while(start<end){
            int middle = start+(end-start)/2 ;
            if(nums[middle]<nums[middle+1]){
                start = middle+1 ;
            }else{
                end = middle ;
            }
        }
        return start;
    }


    public static void main(String[] args) {
//        int[] param = new int[] {1,2,3,1};
        int[] param = new int[] {1,2,1,3,5,6,4};
        int result = new FindPeakElement().findPeakElement(param);
        System.out.println("result=" + result);
    }


}
