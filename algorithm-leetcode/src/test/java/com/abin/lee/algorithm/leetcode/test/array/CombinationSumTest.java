package com.abin.lee.algorithm.leetcode.test.array;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abin on 2018/9/14.
 */
public class CombinationSumTest {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum(candidates, target, 0, res, list);
        return res;
    }

    public void combinationSum(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> list) {
        if (target < 0) return;
        if (target == 0)
            res.add(new ArrayList<>(list));
        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            list.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, res, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = new CombinationSumTest().combinationSum(nums, target);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

}