package com.abin.lee.algorithm.basic.array.common.test;

import java.util.Arrays;

/**
 * Created by abin on 2018/5/31 11:38.
 * algorithm-svr
 * com.abin.lee.algorithm.basic.array.common.test
 * 数组中第k大的数
 *
 */
public class FindKBigInAnyArrayTest {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 4, 7, 6};
        partition(2, arr, 0, arr.length - 1);
        System.out.println("arr="+ Arrays.toString(arr));

    }

    public static void partition(int k ,int[] arr, int low, int high){
        if(low<high){
            int proviet = getProviet(arr, low, high);
            if(proviet == k - 1){
                System.out.println("proviet="+arr[proviet]);
            }else if(proviet > k-1){
                partition(k, arr, low, proviet-1);
            }else{
                partition(k, arr, proviet-1, high);
            }
        }
    }

    public static int getProviet(int[] arr, int low, int high){
        int temp = arr[low] ;
        while(low < high){
            while(low<high & arr[high] < temp){
                high--;
            }
            arr[low] = arr[high];
            while(low<high & arr[low] > temp){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp ;
        return low;
    }




}
