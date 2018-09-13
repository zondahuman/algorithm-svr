package com.abin.lee.algorithm.leetcode.arrarer;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by abin on 2018/9/13.
 * 39. Combination Sum
 * 序列求和
   https://leetcode.com/problems/combination-sum/description/
 https://blog.csdn.net/happyaaaaaaaaaaa/article/details/50897809
 https://www.jianshu.com/p/b2037dd2841a
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result =new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum(candidates, target,result,list, 0);
        return result;
    }
    public void combinationSum(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int start) {
        if(target<0)
            return;
        if(target == 0)
            res.add(new ArrayList<>(list));
        //for循环里面递归相当于是执行了一个N*N的矩阵
        for (int i = start; i <candidates.length && target>=candidates[i] ; i++) {
            list.add(candidates[i]);
            combinationSum(candidates, target-candidates[i], res, list, i);
            list.remove(list.size()-1);
        }
    }

    /**
     * 本题采用回溯算法。
     1. 基本思路是先排好序，这样做的目的是为了对数组后面不可能出现的情况进行排除，有利于减少查找时间，即剪枝操作
     2. 外层循环对数组元素依次进行遍历，依次将 nums 中的元素加入中间集，一旦满足条件，就将中间集加入结果集
     3. 然后每次递归中把剩下的元素一一加到结果集合中，并且把目标减去加入的元素，然后把剩下元素（包括当前加入的元素）放到下一层递归中解决子问题。


     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = new CombinationSum().combinationSum(nums, target);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

}
