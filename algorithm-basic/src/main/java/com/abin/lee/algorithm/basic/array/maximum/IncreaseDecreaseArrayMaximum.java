package com.abin.lee.algorithm.basic.array.maximum;

/**
 * Created by abin on 2018/4/26 0:09.
 * algorithm-svr
 * com.qunar.des.algorithm.basic.array.maximum
 * 一个数组的值先从小到大递增后从大到小递减，找出最大的值
 * https://blog.csdn.net/zheng0518/article/details/49045835
 * 最简单的办法就是从第二个值开始，判断是否满足 A[i] > A[i-1] && A[i] > A[i+1]. 如果满足，i 就是那个最大值的下标。该算法复杂度为O(n).
 */
public class IncreaseDecreaseArrayMaximum {
    /**
     * 最简单的办法就是从第二个值开始，判断是否满足 A[i] > A[i-1] && A[i] > A[i+1]. 如果满足，i 就是那个最大值的下标。该算法复杂度为O(n).
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] params = new int[]{1, 3, 5, 7, 9, 8, 6, 4, 2};
//        int[] params = new int[]{1,3,9,8,7,6,5,4,2};
        int result = findMaximum(params);
//        int result = turningPoint(params);
        System.out.println("result=" + result);
    }

    // the condition "tp > 0 && tp < m -1" makes sure that tp is not at the beginning or the end
    public static int findMaximum(int[] param) {
        int length = param.length;
        int start = 0;
        int end = length - 1;
        int tp = start + (end - start) / 2;
        while (tp > 0 && tp < length - 1) {
            if (param[tp] > param[tp - 1] && param[tp] > param[tp + 1]) {
                return tp;
            } else if (param[tp] < param[tp - 1]) {
                end = tp - 1;
                tp = start + (end - start) / 2;
            } else {
                start = tp + 1;
                tp = start + (end - start) / 2;
            }
        }
        return -1;
    }


}
