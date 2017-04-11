package com.abin.lee.tree.test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: tinkpad
 * Date: 15-11-14
 * Time: 下午8:30
 * To change this template use File | Settings | File Templates.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] input = new int[]{5,1,3,2,6,4};
        sort(input,0,input.length-1);
        System.out.println(Arrays.toString(input));
    }
    public static void sort(int[] input,int start,int end){
        int pivotkeyindex=0;
        if(start<end){
            pivotkeyindex=partition(input, start, end);
            sort(input, start, pivotkeyindex-1);
            sort(input, pivotkeyindex+1, end);
        }
    }
    public static int partition(int[] input,int start,int end){
        int pivotkey = input[start];
        while(start<end){
            while(start<end&&input[end]>=pivotkey)
                --end;
            input[start]=input[end];
            while(start<end&&input[start]<=pivotkey)
                ++start;
            input[end]=input[start];
        }
        input[start]=pivotkey;
        return start;
    }
}
