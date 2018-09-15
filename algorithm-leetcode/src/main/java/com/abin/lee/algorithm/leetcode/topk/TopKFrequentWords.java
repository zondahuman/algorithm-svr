package com.abin.lee.algorithm.leetcode.topk;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.*;

/**
 * Created by abin on 2018/9/15.
 * 692. Top K Frequent Words
 * https://leetcode.com/problems/top-k-frequent-words/description/
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(k, (o1, o2) -> o2.getValue() == o1.getValue() ? o1.getKey().compareTo(o2.getKey()) : o2.getValue() - o1.getValue());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            priorityQueue.offer(entry);
        }
        List<String> result = new LinkedList<>();
        while (result.size() < k) {
            result.add(priorityQueue.poll().getKey());
        }
        return result;
    }
    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        List<Map.Entry<String, Integer>> list= new ArrayList<>(map.entrySet());
        list.sort((o1,o2)-> o2.getValue()==o1.getValue() ? o1.getKey().compareTo(o2.getKey()) : o2.getValue()-o1.getValue());
        List<String> result = new LinkedList<>();
        for (int i = 0; i <k ; i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
//        String[] input = new String[]{"a", "a", "b", "b", "b", "c", "c", "d"};
        List<String> result = new TopKFrequentWords().topKFrequent(input, 2);
//        List<String> result = new TopKFrequentWords().topKFrequent2(input, 2);
        System.out.println("input=" + JsonUtil.toJson(input));
        System.out.println("result=" + JsonUtil.toJson(result));
    }


}
