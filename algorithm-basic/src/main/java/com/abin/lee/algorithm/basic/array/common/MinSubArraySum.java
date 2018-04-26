package com.abin.lee.algorithm.basic.array.common;

/**
 * Created by abin on 2017/12/3 2017/12/3.
 * algorithm-svr
 * 最小和的子数组
 * <LeetCode> 题44：最小子数组（2种可选）
 *  给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
 *  https://blog.csdn.net/kkdd2013/article/details/52078972
 */
public class MinSubArraySum {

    /**
     * 给定一个整数数组，找到一个具有最小和的子数组。返回其最小和。
     注意：子数组最少包含一个数字
     例如：
     给出数组[1, -1, -2, 1]，返回 -3
     * @param args
     */
    public static void main(String[] args) {
        int[] arrays = new int[]{1, -1, -2, 1};
        int violenceResult = violenceSubArraySum(arrays);
        System.out.println("violenceResult="+violenceResult);
        int dpResult = dynamicProgramMinSubArraySum(arrays);
        System.out.println("dpResult="+dpResult);
        int greedyResult = greedySubArraySum(arrays);
        System.out.println("greedyResult="+greedyResult);
    }

    /**
     * 暴力解法，时间复杂度O（n2）
     * @param params
     * @return
     */
    public static int violenceSubArraySum(int[] params){
        int currentSum = 0;
        int minSum = 0;
        for (int i = 0; i < params.length; i++) {
            currentSum = params[i];
            for (int j = i+1; j < params.length; j++) {
                currentSum += params[j];
                if(currentSum < minSum)
                    minSum = currentSum;
            }
        }
        return minSum;
    }

    /**
     * 方法2：优化的动态规划
     思路：首先可以根据数组的最后一个元素a[n-1]与最大子数组的关系分为以下三种情况：
     1) 最大子数组包含a[n-1]，即以a[n-1]结尾。
     2) a[n-1]单独构成最大子数组。
     3) 最大子数组不包含a[n-1]，那么求a[1,...,n-1]的最大子数组可以转换为求a[1,...,n-2]的最大子数组。
     通过上述分析可以得出如下结论：假设已经计算出(a[0],...a[i-1])最大的一段数组和为All[i-1]，同时也计算出(a[0],...a[i-1])中包含a[i-1]的最大的一段数组和为End[i-1]，
     则可以得出如下关系：All[i-1]=max{a[i-1],End[i-1],All[i-1]}。利用这个公式和动态规划的思想解决问题。(代码中还解决了起始位置，终止位置的问题)
     * @param params
     * @return
     */
    public static int dynamicProgramMinSubArraySum(int[] params){
        int min = params[0];
        int currentSum = params[0];
        for (int i = 1; i < params.length; i++) {
            currentSum = Math.min(currentSum+params[i], params[i]);
            min = Math.min(currentSum, min);
        }
        return min;
    }

    /**
     *总是找到一个在当前看来最优的解。
     * 数组中拥有最大和的子数组。
     * 与在添加了下一个元素之前的数组进行比较。
     * 那万一我们加到数组的某一个位置的时候，出现了和为负的情况……
       笨啊，一旦加到某个元素出现和为负的情况，我们就应该舍弃前面的所有元素，然后在下一个元素处重新开始求和。
     如果等于零，那么我们就要从这个元素开始重新求和。另外，不要钻最大子数组在中间的这一种情况的牛角尖，
     除非在计算时数组前面的元素和小于等于零，否则我们在这个代码里，
     永远会得到[0...x]（x代表子数组的最后一个元素序号，[0...x]难道不是他的子数组吗？
     就算我们最后得到数组本身，他也是该数组的子数组）。
     链接：https://juejin.im/post/59b685475188251da2222581
     * @param params
     * @return
     */
    public static int greedySubArraySum(int[] params){
        int minSub = 0;
        int subSum = 0;
        for (int i = 0; i < params.length ; i++) {
            subSum += params[i];
            if(subSum < minSub)
                minSub = subSum;
            if(subSum > 0)
                subSum = 0;
        }
        return minSub;
    }



}
