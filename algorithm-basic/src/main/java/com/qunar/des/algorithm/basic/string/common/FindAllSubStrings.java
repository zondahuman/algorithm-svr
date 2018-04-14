package com.qunar.des.algorithm.basic.string.common;

import com.google.common.collect.Lists;
import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

import java.util.List;

/**
 * Created by abin on 2018/4/15 0:20.
 * algorithm-svr
 * com.qunar.des.algorithm.basic.string.common
 */
public class FindAllSubStrings {

    public static void main(String[] args) {
        String param = "abc";
        List<String> result = getAllSubStrings(param);
        System.out.println("result=" + JsonUtil.toJson(result));
        System.out.println("-------------------------result1-----------------------------------");
        List<String> result1 = getAllSubstrings(param);
        System.out.println("result1=" + JsonUtil.toJson(result1));
        System.out.println("-------------------------result2-----------------------------------");
        List<String> result2 = getAllOrderSubstrings(param);
        System.out.println("result2=" + JsonUtil.toJson(result2));
    }

    public static List<String> getAllSubStrings(String param) {
        List<String> list = Lists.newArrayList();
        if (null == param || "".equals(param)) {
            return null;
        } else {
            char[] arrays = param.toCharArray();
            for (int i = 0; i < arrays.length; i++) {
                String temp = "";
                for (int j = i; j < arrays.length; j++) {
                    temp = temp + arrays[j];
//                    System.out.println("temp= " + temp);
                    list.add(temp);
                }
            }
        }
        return list;
    }

    public static List<String> getAllSubstrings(String param) {
        List<String> list = Lists.newArrayList();
        if (null == param || "".equals(param)) {
            return null;
        } else {
            for (int i = 0; i < param.length(); i++) {
                String temp = new String();
                for (int j = i; j < param.length(); j++) {
                    temp += param.charAt(j);
//                    System.out.println("temp= " + temp);
                    list.add(temp);
                }
            }
        }
        return list;
    }


    public static List<String> getAllOrderSubstrings(String param) {
        List<String> list = Lists.newArrayList();
        if (null == param || "".equals(param)) {
            return null;
        } else {
            for (int i = 0; i < param.length(); i++) {
                String temp = new String();

//                System.out.println(" before temp= " + temp);
//                System.out.println(" before param= " + param);
                for (int j = i; j < param.length(); j++) {
                    temp += param.charAt(j);
                    System.out.println("before   temp= " + temp);
                    list.add(temp);
                    if (temp.length() > 1) {
                        StringBuffer temp1 = new StringBuffer(temp);
                        String temp2 = temp1.reverse().toString();
                        list.add(temp2.toString());
                    }
                    System.out.println("after    temp= " + temp);
                }
            }
        }
        return list;
    }

}