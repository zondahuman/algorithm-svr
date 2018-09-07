package com.abin.lee.algorithm.basic.string.common;

import java.util.*;

/**
 * Created by abin on 2018/9/7.
 * Java统计单词(字符串)出现的顺序并且排序
 */
public class WordCountSort {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("ba");
        list.add("ba");
        list.add("ca");
        list.add("ca");
        list.add("ca");
        Map<String, Integer> mapList = getSort(list);
        System.out.println("mapList=" + mapList);
    }

    public static Map<String, Integer> getSort(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(list.get(i))) {
                map.put(list.get(i), map.get(list.get(i)) + 1);
            } else {
                map.put(list.get(i), 1);
            }
        }
        List<Map.Entry<String, Integer>> mapList = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(mapList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        Map<String, Integer> resultMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : mapList) {
//            System.out.println("key=" + entry.getKey() + " , value=" + entry.getValue());
            resultMap.put(entry.getKey(), entry.getValue());
        }
        return resultMap;
    }
}
