package com.abin.lee.algorithm.chain.single.model2.test;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-9 下午10:18
 */
public class SingleList {
    private Node header;

    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = header;
        header = node;
    }
    public void addAnyPosition(int data,int index) {
        Node current = header;
        int i=0;
        while(current.data != data){
            if(i == index){
                Node node = new Node(data);

            }

        }
    }
    public void addLast(int data) {
        Node current = header;
        while(current.next != null){
             current = current.next;
        }
        current.next = new Node(data);
    }
    public Node deleteFirst() {
        Node node = header;
        header = header.next;
        node.next=null;
        return node;
    }
    public Node deleteLast() {
        Node node = header;
        header = header.next;
        node.next=null;
        return node;
    }
    public Node find(int data){
        Node node = header;
        while(node.data != data){
            if(node.next == null)
                  return null;
            else
                node = node.next;
        }
        return node;
    }
    public Node findByIndex(int index){
        Node node = header;
        AtomicInteger increment = new AtomicInteger(1);
        while(null != node){
            if(increment.get() == index){
                 return node;
            }else{
                 node = node.next;
            }
            increment.getAndIncrement();
        }
        return null;
    }

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addFirst(2);
        singleList.addFirst(6);
        singleList.addFirst(7);
        singleList.addFirst(3);
        singleList.addFirst(9);
        System.out.println("singleList--addFirst="+ JsonUtil.toJson(singleList.header));
        Node findNode = singleList.find(3);
        System.out.println("findNode="+ JsonUtil.toJson(findNode));
        Node findByIndex = singleList.findByIndex(4);
        System.out.println("findByIndex="+ JsonUtil.toJson(findByIndex));
        singleList.addLast(4);
        System.out.println("singleList--addLast="+ JsonUtil.toJson(singleList.header));
        Node delNode = singleList.deleteFirst();
        System.out.println("delNode="+ JsonUtil.toJson(delNode));
    }

}
