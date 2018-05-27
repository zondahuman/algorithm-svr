package com.abin.lee.algorithm.special.common.connect;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;
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
public class LinkedListConnection {
    private static LinkedList<Connect> avaiable ;
    private static LinkedList<Connect> idle ;
    private Object lock = new Object();
    static {
        idle = new LinkedList<Connect>();
        for (int i = 0; i <5 ; i++) {
            idle.add(new Connect("lee"+i));
        }
        avaiable = new LinkedList<Connect>();
    }

    public Connect getConnection(){
        Connect connect = null ;
        synchronized (lock){
            connect = idle.remove((int)(Math.random()*5));
            avaiable.push(connect);
        }
        System.out.println("getConnection---idle=" + JsonUtil.toJson(idle));
        System.out.println("getConnection---avaiable=" + JsonUtil.toJson(avaiable));
        return connect;
    }

    public void releaseConnection(Connect connect){
        synchronized (lock){
            avaiable.remove(connect);
            idle.push(connect);
        }
        System.out.println("releaseConnection---idle=" + JsonUtil.toJson(idle));
        System.out.println("releaseConnection---avaiable=" + JsonUtil.toJson(avaiable));
    }

    public static void main(String[] args) {
        System.out.println("main---idle=" + JsonUtil.toJson(idle));
        System.out.println("main---avaiable=" + JsonUtil.toJson(avaiable));
        LinkedListConnection linkedListConnection = new LinkedListConnection() ;
        Connect connect = linkedListConnection.getConnection();
        linkedListConnection.releaseConnection(connect);
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Connect {
        private String name;
    }



}
