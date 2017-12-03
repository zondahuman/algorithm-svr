package com.qunar.des.algorithm.basic.array.common;

/**
 * Created by abin on 2017/12/3 2017/12/3.
 * algorithm-svr
 * com.qunar.des.algorithm.basic.array.common
 * https://www.cnblogs.com/litao-tech/p/4163576.html
 * http://blog.csdn.net/linshengchao123/article/details/39433623
 * http://blog.csdn.net/qq_31010431/article/details/52205840
 * 求一维数组中不重叠的两个子数组的最大和(求两个子数组最大的累加和)
 * 给定一个长度为N的整数数组a，求不重叠的两个子数组的和的最大值。
 如a[6]={1, 2, -4, 3, 2, -5}。所取的子数组分别为{1，2}{3, 2}时，两个子数组的和最大，为3+5=8。
 这个题目是数组的子数组最大和（即最大连续和）的变形（后面附上了求解子数组最大和的程序）。
 一种方法是把数组分成两部分（[0~i]和[i+1~len-1]），分别求两部分的最大连续和相加，再从中选出最大的。时间复杂度是O(N*N)。这种方法在求解最大连续和时会有冗余的计算，需要优化。
 第二种方法申请两个独立数组，用sum1[i]记录数组[0~i]的最大连续和，sum2[i]记录数组[i, len-1]的最大连续和。那么max(sum1[i]+sum2[i+1]) for every 0<=i<len-1 就是所求的最大值。时间复杂度O(N)。代码如下：
 */
public class TwoSubArraySum {

    public static void main(String[] args) {
        int params[]={1, 2, -4, 3, 2, -5};
        int result = maxTwoSubArray(params);
        System.out.println("result=" + result);
        int result1 = maxTwoSubArrayDp(params);
        System.out.println("result1=" + result1);
    }

    /**
     * 问题：给定一个数组，其中当然有很多的子数组，在所有两个子数组的组合中，找到相加和最大的一组，要求两个子数组无重合的部分。最后返回累加和。
     要求： 时间复杂度达到 O(N)
     解法：我们很容易想到将整个数组分成两个部分，然后分别求这两个部分子数组的最大累加和。将结果累加起来。那么将数组分成不重合两部分（相邻的两部分）有N-1种分法，根据算法原型就是leetcode 53. Maximum Subarray 子数组最大和，求子数组最大和的时间复杂度是O(N)，整体的时间复杂度达到了O(N*N)。那么如何将时间复杂度降到O(N)呢？分析我们的算法原型，其中的max会保存遍历到当前位置的子数组的最大和，我们可以将这个值保存起来，这样我们就可以用O(1)的时间复杂度得到当前子数组的最大累加和。整体的时间复杂度也是O(N)级别的。由于我们要将数组分成两部分，预处理时，我们需要计算一遍从右到左的子数组最大和，这样右边的部分我们也可以直接拿到它的子数组最大累加和，左边的部分我们不用数组保存，因为我们是从左到右遍历的，只用一个变量保存即可。这是我们用空间换时间的一个方法。额外空间复杂度为O(N)。
     * @param nums
     * @return
     */
    public static int maxTwoSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] h = new int[nums.length];
        h[h.length - 1] = nums[nums.length - 1];
        int cur = h[h.length - 1];
        for (int i = h.length - 2; i >= 0; i--) {
            cur += nums[i];
            h[i] = Math.max(cur, h[i + 1]);
            if (cur < 0) {
                cur = 0;
            }
        }
        int max = Integer.MIN_VALUE;
        int lMax = Integer.MIN_VALUE;
        cur = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            cur += nums[i];
            lMax = Math.max(lMax, cur);
            max = Math.max(max, lMax + h[i + 1]);
            if (cur < 0) {
                cur = 0;
            }
            System.out.println(lMax + " " + h[i+1] + " " + i + " " + max);
        }
        return max;
    }

    public static int maxTwoSubArrayDp(int[] nums) {
        int length = nums.length;
        int pre[] = new int[length];
        int post[] = new int[length];
        int max = 0;
        int temp = 0;
        for (int i = 0; i < length; i++) {
            if(temp < 0)
                temp = nums[i];
            else
                temp += nums[i];
            if(temp > max)
                max = temp;
            pre[i] = max;
        }
        max = 0;
        temp = 0;
        for (int i = length-1; i >=0 ; i--) {
            if(temp < 0)
                temp = nums[i];
            else
                temp += nums[i];
            if (temp > max)
                max = temp;
            post[i] = max;
        }
        max = 0;
        for (int i = 0; i <length-1 ; i++) {
            if (pre[i] + post[i] > max){
                max = pre[i] + post[i];
            }
        }
        return max;
    }


}
