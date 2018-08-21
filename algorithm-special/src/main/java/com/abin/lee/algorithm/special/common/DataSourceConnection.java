package com.abin.lee.algorithm.special.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by abin on 2018/5/26 23:26.
 * algorithm-svr
 * com.abin.lee.algorithm.special.common
 * 实现连接池的getConnection和releaseConnection
 */
public class DataSourceConnection {
    private static List<Connect> avaiable ;
    private static List<Connect> idle ;
    static {
        idle = new LinkedList<Connect>();
        for (int i = 0; i <100 ; i++) {
            idle.add(new Connect("lee"+i));
        }
        avaiable = new LinkedList<Connect>();
    }

    public Connect getConnection(){

        return null;
    }

    public void releaseConnection(){

    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Connect {
        private String name;
    }


    public static void main(String[] args) {
        String ids = "2018082121001004950595545047";
        Long idl = Long.MAX_VALUE;
        System.out.println("idl="+idl);
        System.out.println("ids="+ids);
    }







}
