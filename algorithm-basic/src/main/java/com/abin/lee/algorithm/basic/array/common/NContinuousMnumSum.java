package com.abin.lee.algorithm.basic.array.common;

import java.util.Arrays;

/**
 * Created by abin on 2018/5/18 13:53.
 * algorithm-svr
 * com.abin.lee.algorithm.basic.array.common
 * n个整数中找出连续m个数加和是最大Java版
 * https://blog.csdn.net/qq_34122768/article/details/78391260
 */
public class NContinuousMnumSum {
    public static void main(String[] args) {
        // int[] 数组 asList返回 int[];形式List对象
        int[] paras = { 1, 2, 3, 4, 5, 4, 3, 1, 1, 2};
        int[] result = getM(paras, 5);
        System.out.println(Arrays.toString(result));
    }

    public static int[] getM(int[] params, int m){
        if(null == params || params.length<=0)
            return null;
        int[] current = new int[m];
        int[] max = new int[m];
        for (int i = 0; i <params.length ; i++) {
            if (i + m < params.length){
                System.arraycopy(params, i, current, 0, m);
            }
            if(params[0] == 0 || (params[0] != 0 && getNum(current) > getNum(max))){
                System.arraycopy(current, 0, max, 0 ,m);
            }
        }
        return max;
    }

    public static int getNum(int[] temp){
        int result = 0;
        for (int i = 0; i <temp.length ; i++) {
            result += temp[i];
        }
        return result;
    }
}
