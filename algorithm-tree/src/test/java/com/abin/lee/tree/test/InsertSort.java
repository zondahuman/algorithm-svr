package com.abin.lee.tree.test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: tinkpad
 * Date: 15-11-14
 * Time: 下午11:12
 * To change this template use File | Settings | File Templates.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] input = new int[]{5,1,3,2,6,4};
        sort(input);
        System.out.println(Arrays.toString(input));
    }
    public static void sort(int[] input){
        int target = 0;
        for(int i=0;i<input.length;i++){
            int j = i;
            target = input[i];
            while(j>0&&target<input[j-1]){
                input[j] = input[j-1];
                j--;
            }
            input[j] = target;
        }
    }
}
