package com.abin.lee.algorithm.leetcode.arrarer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by abin on 2018/9/6.
 * 169. Majority Element
 * 数组中出现次数最多的元素
 * https://blog.csdn.net/dashenxueba/article/details/78708147
 * https://leetcode.com/problems/majority-element/description/
 * https://leetcode.com/problems/majority-element/solution/
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int max = 0;
        int index = 0;
        if (nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            if (map.get(nums[i]) > max) {
                max = map.get(nums[i]);
                index = nums[i];
            }
        }
        return index;
    }


    public int majorityElement1(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement3(int[] num) {
        int major = num[0], count = 1;
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) {
                count++;
            } else count--;

        }
        return major;
    }

    public static void main(String[] args) {
        int[] input = {1, 1, 2, 2, 4, 4, 4, 4, 5, 5, 6, 6};
        int result1 = new MajorityElement().majorityElement3(input);
        System.out.println("result1=" + result1);

    }


}
