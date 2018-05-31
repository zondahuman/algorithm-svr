package com.qunar.des.algorithm.sort.test.quick;

import java.util.Arrays;

/**
 * Created by abin on 2018/5/31 11:18.
 * algorithm-svr
 * com.qunar.des.algorithm.sort.test.quick
 */
public class QuickSort1 {
    public static void main(String[] args) {
//        int[] input = {1,5,2,6,0};
        int[] input = {3, 1, 2, 5, 4, 7, 6};
        partition(input, 0, input.length-1);
        System.out.println("input="+ Arrays.toString(input));
    }

    public static void partition(int[] arr, int low, int high){
        if(low < high){
            int middle = getMiddle(arr, low, high) ;
            partition(arr, low, middle-1);
            partition(arr, middle+1, high);
        }
    }
    public static int getMiddle(int[] arr, int low, int high){
        int temp = arr[low];
        while(low < high){
            while(low < high & arr[high] > temp) {
                high--;
            }
            arr[low] = arr[high] ;
            while(low < high & arr[low] < temp) {
                low++;
            }
            arr[high] = arr[low] ;
        }
//        arr[low] = temp;
//        return low;
        arr[high] = temp;
        return high;
    }



}
