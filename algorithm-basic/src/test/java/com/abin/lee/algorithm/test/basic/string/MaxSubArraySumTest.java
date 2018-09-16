package com.abin.lee.algorithm.test.basic.string;

/**
 * Created by abin on 2017/12/6 11:42.
 * algorithm-svr
 * com.abin.lee.algorithm.basic.strings.test
 * 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
 */
public class MaxSubArraySumTest {

    /**
     * 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
     * 样例
     * 给出数组[−2,2,−3,4,−1,2,1,−5,3]，符合要求的子数组为[4,−1,2,1]，其最大和为6
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arrays = new int[]{-2, 2, -3, 4, -1, 2, 1, -5, 3};
        int violenceResult = maxSimpleSum(arrays);
        System.out.println("violenceResult=" + violenceResult);
        int dpResult = maxDynamicProgramSum(arrays);
        System.out.println("dpResult=" + dpResult);
//            int greedyResult = greedySubArraySum(arrays);
//            System.out.println("greedyResult="+greedyResult);
    }

    public static int maxSimpleSum(int[] params) {
        int currentSum = 0;
        int maxSum = 0;
        for (int i = 0; i < params.length; i++) {
            currentSum = params[i];
            for (int j = i + 1; j < params.length; j++) {
                currentSum += params[j];
                if (currentSum > maxSum)
                    maxSum = currentSum;
            }
        }
        return maxSum;
    }

    public static int maxDynamicProgramSum(int[] params) {
        int remainSum = 0;
        int totalSum = 0;
        for (int i = 0; i < params.length; i++) {
            remainSum = Math.max(remainSum + params[i], params[i]);
            totalSum = Math.max(remainSum, totalSum);
        }
        return totalSum;
    }

}
