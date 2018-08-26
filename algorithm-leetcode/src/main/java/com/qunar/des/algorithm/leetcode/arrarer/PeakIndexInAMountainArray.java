package com.qunar.des.algorithm.leetcode.arrarer;

/**
 * Created by abin on 2018/8/26.
 * 852. Peak Index in a Mountain Array
 https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
 */
public class PeakIndexInAMountainArray {
    /**
     * Example 1:

     Input: [0,1,0]
     Output: 1
     Example 2:

     Input: [0,2,1,0]
     Output: 1
     * @param A
     * @return
     */
    public int peakIndexInMountainArray(int[] A) {
        int start = 0;
        int end = A.length-1;
        while(start<end){
            int middle = start + (end-start)/2;
            if(A[middle]<A[middle+1]){
                start = middle+1;
            }else{
                end = middle ;
            }
        }
        return end ;
    }

    public static void main(String[] args) {
        int[] param = new int[] {0,1,0};
//        int[] param = new int[] {0,2,1,0};
        int result = new PeakIndexInAMountainArray().peakIndexInMountainArray(param);
        System.out.println("result=" + result);
    }
}
