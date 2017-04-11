package com.qunar.des.algorithm.sort.test.merge;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-3-27 下午10:14
 */
public class MergeSort {
    public static int[] sort(int[] input,int low,int high){
        if (low<high){
            int middle = (low+high)/2;
            sort(input,low,middle);
            sort(input,middle+1,high);
//            merge()
        }
        return input;
    }
    public static void merge(){

    }
}
