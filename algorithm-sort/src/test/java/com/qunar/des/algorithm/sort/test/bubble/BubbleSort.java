package com.qunar.des.algorithm.sort.test.bubble;

import java.util.Arrays;

/**
 * Created by abin on 2018/5/31 20:02.
 * algorithm-svr
 * com.qunar.des.algorithm.sort.test.bubble
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] input = new int[]{1, 0, 4, 3, 5, 2, 6, 9, 8, 7};
        input = bubble(input);
        System.out.println(Arrays.toString(input));
    }

    public static int[] bubble(int[] params){
        for (int i = 0; i < params.length; i++) {
            for (int j = 0; j < params.length-i-1; j++) {
                if(params[j] > params[j+1]){
                    int temp = params[j] ;
                    params[j] = params[j+1];
                    params[j+1] = temp;
                }
            }
        }
        return params;
    }


}
