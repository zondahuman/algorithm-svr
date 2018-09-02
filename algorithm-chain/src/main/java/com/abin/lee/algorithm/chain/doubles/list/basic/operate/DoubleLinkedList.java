package com.abin.lee.algorithm.chain.doubles.list.basic.operate;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/9/2.
 */
public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int count;

    public DoubleLinkedList() {
        head = new Node(null);
        tail = new Node(null);
        this.head = tail;
        count++;
    }

    public int size() {
        return this.count;
    }

    /**
     * 要对链表进行判断，如果为空则设置尾节点为新添加的节点，如果不为空，还要设置头节点的一个前节点为新节点
     *
     * @param obj
     * @return
     */
    public boolean addHead(int obj) {
        Node node = new Node(obj, null, this.head);
        this.head.pre = node;
        this.head = node;
        if (tail == null)
            tail = this.head;
        count++;
        return true;
    }
    public void addNode(int obj) {
        Node newNode = new Node(obj);
        if (head == null) {
            head = newNode;
            tail = newNode;
            count = 1;
            return;
        }

        Node tailTmp = tail;
        tailTmp.next = newNode;
        newNode.pre = tailTmp;
        tail = newNode;
        count++;
    }



    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.addHead(1);
        doubleLinkedList.addNode(1);
        System.out.println("doubleLinkedList.head=" + JsonUtil.toJson(doubleLinkedList.head));
        System.out.println("doubleLinkedList.tail=" + JsonUtil.toJson(doubleLinkedList.tail));
    }


    public static class Node {
        int val;
        Node pre;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(Node node) {
            this.pre = node;
            this.next = node;
        }

        public Node(int val, Node pre, Node next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
