package com.abin.lee.algorithm.basic.array.maximum;

/**
 * Created by abin on 2018/4/26 0:09.
 * algorithm-svr
 * com.qunar.des.algorithm.basic.array.maximum
 * 一个数组的值先从大到小递减后从小到大递增，找出最小的值
 * https://blog.csdn.net/zheng0518/article/details/49045835
 * https://blog.csdn.net/varyall/article/details/80070208
 * 最简单的办法就是从第二个值开始，判断是否满足 A[i] < A[i-1] && A[i] < A[i+1]. 如果满足，i 就是那个最大值的下标。该算法复杂度为O(n).
 */
public class DecreaseIncreaseArrayMinimum {
    /**
     * @param args
     */
    public static void main(String[] args) {
//        int[] params = new int[]{1,2,3,4,5,6,7,8,9};
//        int[] params = new int[]{9,8,7,6,5,4,3,2,1};
        int[] params = new int[]{9,8,6,4,2,1,3,5,7};
//        int[] params = new int[]{9, 8, 7, 6, 5, 4, 2, 1, 3};
        int result = findMinimum(params);
        System.out.println("result=" + result);
    }

    public static int findMinimum(int[] param) {
        int length = param.length;
        int start = 0;
        int end = length - 1;
        int tp = start + (end - start) / 2;
        while (tp > 0 && tp < length - 1) {
            if (param[tp] < param[tp - 1] && param[tp] < param[tp + 1]) {
                return tp;
            } else if (param[tp] > param[tp - 1]) {
                end = tp - 1;
                tp = start + (end - start) / 2;
            } else if (param[tp] > param[tp + 1]) {
                start = tp + 1;
                tp = start + (end - start) / 2;
            }
        }
        return -1;
    }


}
