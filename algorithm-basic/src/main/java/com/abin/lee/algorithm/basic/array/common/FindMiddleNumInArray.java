package com.abin.lee.algorithm.basic.array.common;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/5/31 0:41.
 * algorithm-svr
 * com.abin.lee.algorithm.basic.array.common
 * 无序数组的中位数
 * https://www.cnblogs.com/shizhh/p/5746151.html
 * 找出一个无序数组的中位数 :  https://blog.csdn.net/oneday_789/article/details/76681764
 */
public class FindMiddleNumInArray {
    /**
     * 采用快速排序
     * @param args
     */
    public static void main(String[] args) {
        int[] array1 = new int[]{3,4,2,1,5,6,7};
        sort(array1, 0, array1.length-1);
        System.out.println("array1="+ JsonUtil.toJson(array1));
    }

    public static void sort(int arr[],int low,int high)
    {
        int l=low;
        int h=high;
        int povit=arr[low];

        while(l<h)
        {
            while(l<h&&arr[h]>=povit) h--;
            if(l<h){
                int temp=arr[h];
                arr[h]=arr[l];
                arr[l]=temp;
                l++;
            }

            while(l<h&&arr[l]<=povit) l++;

            if(l<h){
                int temp=arr[h];
                arr[h]=arr[l];
                arr[l]=temp;
                h--;
            }
        }

        if(l>low) sort(arr,low,l-1);
        if(l<high) sort(arr,l+1,high);
    }





}
