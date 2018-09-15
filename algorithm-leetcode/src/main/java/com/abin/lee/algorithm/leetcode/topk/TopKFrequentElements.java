package com.abin.lee.algorithm.leetcode.topk;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.*;

/**
 * Created by abin on 2018/9/15.
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (queue.size() < k) {
                queue.add(entry);
            } else {
                if (entry.getValue() > queue.peek().getValue()) {
                    queue.poll();
                    queue.add(entry);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(queue.poll().getKey());
        }
        return list;
    }

    public List<Integer> topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            queue.add(entry);
        }
        List<Integer> list = new ArrayList<>();
        while (list.size() < k) {
            list.add(queue.poll().getKey());
        }
        return list;
    }


    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        Map<Integer, Integer> sortMap = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
//            list.add(map.get());
        }
        return list;
    }

    public List<Integer> topKFrequent4(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }

    public List<Integer> topKFrequent5(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }

    public List<Integer> topKFrequent6(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
//        Collections.sort(list, Comparator.comparing(Map.Entry::getValue).reversed());
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }

    public List<Integer> topKFrequent7(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1,o2) -> o2.getValue().compareTo(o1.getValue()));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }

    public List<Integer> topKFrequent8(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (Iterator<Map.Entry<Integer, Integer>> iterator=map.entrySet().iterator();iterator.hasNext();){
            Map.Entry<Integer, Integer> entry = iterator.next();
            if(!treeMap.containsKey(entry.getValue())){
                treeMap.put(entry.getValue(), new ArrayList<>());
            }
            treeMap.get(entry.getValue()).add(entry.getKey());
        }
        List<Integer> result = new ArrayList<>();
        while(result.size()<k){
            Map.Entry<Integer, List<Integer>> entry = treeMap.pollLastEntry();
            result.addAll(entry.getValue());
        }
        return result;
    }


    public static void main(String[] args) {
        int[] input = new int[]{1, 1, 1, 2, 2, 3, 3, 4};
        int[] param = new int[3];
//        List<Integer> result = new TopKFrequentElements().topKFrequent(input, 2);
//        List<Integer> result = new TopKFrequentElements().topKFrequent3(input, 2);
//        List<Integer> result = new TopKFrequentElements().topKFrequent2(input, 2);
//        List<Integer> result = new TopKFrequentElements().topKFrequent4(input, 2);
//        List<Integer> result = new TopKFrequentElements().topKFrequent5(input, 2);
//        List<Integer> result = new TopKFrequentElements().topKFrequent6(input, 2);
//        List<Integer> result = new TopKFrequentElements().topKFrequent7(input, 2);
        List<Integer> result = new TopKFrequentElements().topKFrequent8(input, 2);
        System.out.println("input=" + JsonUtil.toJson(input));
        System.out.println("result=" + JsonUtil.toJson(result));
    }

}