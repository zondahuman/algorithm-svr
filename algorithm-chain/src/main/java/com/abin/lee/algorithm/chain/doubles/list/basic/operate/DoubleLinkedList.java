package com.abin.lee.algorithm.chain.doubles.list.basic.operate;

import com.google.common.base.MoreObjects;
import com.qunar.des.algorithm.common.json.jackson.JsonUtil;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by abin on 2018/9/2.
 * 双向链表操作
 * https://www.cnblogs.com/snowwang/p/6074577.html
 * https://blog.csdn.net/lsly521/article/details/79208301
 *
 * 这里双向链表，头结点和末节点虽然初始化了-1，-2，没有实际意义，只是为了初始化，实际它里面可以不放置任何东西，不参与运算，只是为了运算简单化
 */
public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int count;

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
        Node node = new Node(obj);
        if(null == head){
            head = new Node(-1, null, null);
            this.head.next = node;
            node.pre = head;
            if(null == tail){
                tail = new Node(-2, null, null);
            }
            tail.pre = node;
            node.next = tail;
        }else{
            this.head.next.pre = node;
            node.next = head.next;

            this.head.next = node;
            node.pre = head;

        }
        count++;
        return true;
    }

    public Node getNode(int index){
        if(index == 0)
            return head.next;
        if(index == count)
            return tail.pre;
        int length=0;
        Node node = head;
        for (int i = 0; i <count ; i++) {
            node = node.next;
            ++length;
            if(length == index)
                return node;
        }
        return null;
    }



    public boolean addTail(int obj) {
        Node node = new Node(obj);

        tail.pre.next  = node ;
        node.pre = tail.pre;

        node.next = tail;
        tail.pre  = node;

        count++;
        return true;
    }


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addHead(1);
        doubleLinkedList.addHead(3);
        doubleLinkedList.addHead(5);
        doubleLinkedList.addHead(7);
        doubleLinkedList.addHead(9);
//        doubleLinkedList.addTail(2);

//        System.out.println("doubleLinkedList.head=" + JsonUtil.toJson(doubleLinkedList.head));
//        System.out.println("doubleLinkedList.tail=" + JsonUtil.toJson(doubleLinkedList.tail));
        Node node = doubleLinkedList.getNode(1);
//        Node node = doubleLinkedList.getNode(4);
        System.out.println("node=" + node.toString());


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

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("val", val)
                    .append("pre", pre)
                    .append("next", next)
                    .toString();
        }
    }
}
