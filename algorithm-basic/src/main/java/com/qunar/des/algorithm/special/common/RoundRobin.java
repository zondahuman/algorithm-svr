package com.qunar.des.algorithm.special.common;

import java.util.*;

/**
 * Created by abin on 2017/12/19 11:07.
 * algorithm-svr
 * com.qunar.des.algorithm.special.common
 */
public class RoundRobin {
    // 待路由的Ip列表，Key代表Ip，Value代表该Ip的权重
    public static HashMap<String, Integer> serverWeightMap =
            new LinkedHashMap<String, Integer>();
    private static volatile Integer pos = 0;
    static
    {
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.101", 1);
        // 权重为4
        serverWeightMap.put("192.168.1.102", 4);
        serverWeightMap.put("192.168.1.103", 1);
        serverWeightMap.put("192.168.1.104", 1);
        // 权重为3
        serverWeightMap.put("192.168.1.105", 3);
        serverWeightMap.put("192.168.1.106", 1);
        // 权重为2
        serverWeightMap.put("192.168.1.107", 2);
        serverWeightMap.put("192.168.1.108", 1);
        serverWeightMap.put("192.168.1.109", 1);
        serverWeightMap.put("192.168.1.110", 1);
    }

    public static String getServer(){
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap =
                new LinkedHashMap<String, Integer>();
        serverMap.putAll(serverWeightMap);

        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        List<String> keyList = new LinkedList<>();
        keyList.addAll(keySet);

        String server = "";
        synchronized (pos){
            if(pos >= keySet.size())
                pos = 0;
            server = keyList.get(pos);
            pos++;
        }
        return server;
    }

    public static void main(String[] args) {
        for (int i = 0; i <15 ; i++) {
            String server = getServer();
            System.out.println("server="+server);
        }

    }


}
