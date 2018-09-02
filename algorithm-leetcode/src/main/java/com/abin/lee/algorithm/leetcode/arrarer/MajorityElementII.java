package com.abin.lee.algorithm.leetcode.arrarer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abin on 2018/7/8.
 * 229. Majority Element II
 * https://leetcode.com/problems/majority-element-ii/discuss/
 * https://blog.csdn.net/zhouyanz/article/details/50952803
 */
public class MajorityElementII {


    public List<Integer> majorityElement(int[] nums) {
        //可能有0-2个这样的数
        int cand1 = 0, cand2 = 0, amo1 = 0, amo2 = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == cand1) {
                amo1++;
            } else if (nums[i] == cand2) {
                amo2++;
            } else if (amo1 == 0) {
                amo1++;
                cand1 = nums[i];
            } else if (amo2 == 0) {
                amo2++;
                cand2 = nums[i];
            } else {
                amo1--;
                amo2--;
            }
            i++;
        }

        i = 0;
        int numC1 = 0, numC2 = 0, C = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == cand1) numC1++;
            if (nums[i] == cand2) numC2++;
            C++;
        }
        List<Integer> ret = new ArrayList<>();
        if (numC1 > C / 3) ret.add(cand1);
        if (numC2 > C / 3 && cand1 != cand2) ret.add(cand2);
        return ret;
    }


}
