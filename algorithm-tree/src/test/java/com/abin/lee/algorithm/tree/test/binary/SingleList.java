package com.abin.lee.algorithm.tree.test.binary;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-11-15
 * Time: 下午5:16
 * To change this template use File | Settings | File Templates.
 */
public class SingleList {
    private static Node header;
    public static class Node{
        Integer data;
        Node next;

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    public static void add(Integer data){
        if(null == header)
            header = new Node(data,null);
        else
            header = new Node(data,header);
    }
    public static Node findByIndex(int index){
        Node node = header;
        AtomicInteger increase = new AtomicInteger(0);
        while(null != node){
            if(increase.get() == index)
                return node;
            else
                node = node.next;
            increase.getAndIncrement();
        }
        return null;
    }
    public static Node find(int data){
        Node node = header;
        while(null != node){
            if(node.getData() == data)
                return node;
            else
                node = node.next;
        }
        return null;
    }
    public static void insert(int index, int data){

    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,1,2,9,3,4,8,7,5};
        for(int i=0;i<arr.length;i++){
            add(arr[i]);
        }
        System.out.println("header="+ JsonUtil.toJson(header));
        Node findNodeByIndex = findByIndex(2);
        System.out.println("findNodeByIndex= "+JsonUtil.toJson(findNodeByIndex));
        Node findNode = find(2);
        System.out.println("findNode= "+JsonUtil.toJson(findNode));
    }

}
