package com.abin.lee.algorithm.chain.single.model1.test;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-4 下午4:53
 */
public class Node {
    public Node next;
    public int data;

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
