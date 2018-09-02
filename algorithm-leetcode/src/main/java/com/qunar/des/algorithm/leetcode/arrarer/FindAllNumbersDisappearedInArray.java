package com.qunar.des.algorithm.leetcode.arrarer;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abin on 2018/8/2.
 * <p>
 * 448. Find All Numbers Disappeared in an Array
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 * https://blog.csdn.net/qqzj_bupt/article/details/53769960
 *
 */
public class FindAllNumbersDisappearedInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = -Math.abs(nums[index]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                list.add(i+1);
        }
        return list;
    }

    /**
     * Input:
     [4,3,2,7,8,2,3,1]
     Output:
     [5,6]
     * @param args
     */
    public static void main(String[] args) {
        int[] input = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = new FindAllNumbersDisappearedInArray().findDisappearedNumbers(input);
        System.out.println("list=" + JsonUtil.toJson(list));
    }


}
