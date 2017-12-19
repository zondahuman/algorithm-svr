package com.abin.lee.algorithm.tree.test.binary;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: tinkpad
 * Date: 15-11-14
 * Time: 下午8:04
 * To change this template use File | Settings | File Templates.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] input = new int[]{5,1,3,2,6,4};
        sort(input,0,input.length-1);
        System.out.println(Arrays.toString(input));

    }

    public static void sort(int[] input,int start,int end){
        if(start<end){
            int middle = (start+end)/2;
            sort(input,start,middle);
            sort(input,middle+1,end);
            merge(input,start,middle,end);
        }
    }
    public static void merge(int[] input,int start,int middle,int end){
        int[] temp = new int[input.length];
        int left = start;
        int mleft = middle+1;
        int k = left;
        while(left<=middle&&mleft<=end){
            if(input[left]<input[mleft])
                temp[k++]=input[left++];
            else
                temp[k++]=input[mleft++];
        }
        while(left<=middle)
            temp[k++]=input[left++];
        while(mleft<=end)
            temp[k++]=input[mleft++];
        while(start<=end)
            input[start] = temp[start++];
    }
}
