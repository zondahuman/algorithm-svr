package com.abin.lee.algorithm.chain.single.model1.test;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-4 下午4:59
 */
public class SingleList {
    public Node header ;

    public void add(int data) {
        if (null == header) {
            header = new Node(data, null);
        } else {
            header = new Node(data, header);
        }
    }
    public void insert(int data){

    }

    public int getSize() {
        Node pointer = header;
        AtomicInteger index = new AtomicInteger(0);
        while (pointer != null) {
            index.getAndIncrement();
            pointer = pointer.next;
        }
        return index.get();
    }
    public Node search(int index){
        Node pointer = header;
        AtomicInteger count = new AtomicInteger(0);
        while(pointer != null){
            if(count.get() == index){
                return pointer;
            }
            count.getAndIncrement();
            pointer = pointer.next;
        }
        return null;
    }

    public void delete(int index) {
        int size = getSize();
        Node pointer = header;
        AtomicInteger count = new AtomicInteger(0);
        while (pointer != null) {
             if(count.get() == index){
                 if(index == size - 1){
                     pointer.next = null;
                 }else{
                     pointer.next = pointer.next.next;
                 }
             }
            pointer = pointer.next;
            count.getAndIncrement();
        }
    }
    public Node reverse(Node head){
        if(null == head || null ==head.next){
            return head;
        }
        Node reverseHeader = reverse(head.next);
        head.next.setNext(head);
        head.setNext(null);
        return reverseHeader;
    }

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.add(0);
        singleList.add(1);
        singleList.add(2);
        singleList.add(3);
        singleList.add(4);
        singleList.add(5);
        System.out.println("singleList=" + JsonUtil.toJson(singleList.header));
        int size = singleList.getSize();
        System.out.println("size=" + size);
        Node searchNode = singleList.search(5);
        System.out.println("searchNode="+JsonUtil.toJson(searchNode));
        singleList.delete(2);
        System.out.println("delete--singleList=" + JsonUtil.toJson(singleList.header));
        Node reverseHead = singleList.reverse(singleList.header);
        System.out.println("reverseHead="+JsonUtil.toJson(reverseHead));
    }
}
