package com.abin.lee.algorithm.chain.single.insert.test;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by abin on 2017/12/20 2017/12/20.
 * algorithm-svr
 * com.abin.lee.algorithm.chain.single.insert.test
 */
public class SingleListInsertTest {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        root.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println("root="+ JsonUtil.toJson(root));
//        Node nodeHeader = addHeader(root, new Node(9));
//        System.out.println("nodeHeader="+ JsonUtil.toJson(nodeHeader));
//        Node addTail = addTail(root, new Node(9));
//        System.out.println("addTail="+ JsonUtil.toJson(addTail));
        Node addAny = addAny(root, 2, new Node(9));
        System.out.println("addAny="+ JsonUtil.toJson(addAny));
//        Node insert = insert(root, 3, 9);
//        System.out.println("insert="+ JsonUtil.toJson(insert));

    }

    public static Node addHeader(Node header, Node node){
        node.next = header;
        return node;
    }
    public static Node addTail(Node header, Node node){
        Node temp = header;
        while(null != temp.next){
            temp = temp.next;
        }
        temp.next = node;
        return header;
    }
    public static Node addAny(Node header, int index, Node node){
        Node add = header;
        if(index == 0){
            node.next = header;
            return node;
        }else {
            while (null != add.next && index > 2) {
                add = add.next;
                index--;
            }
            node.next = add.next;
            add.next = node;
        }
        return header;
    }

    public static Node insert(Node head, int index,Integer obj){
        Node node=head;
        int j=0;
        while(node!=null&&j<index-2){
            //查找到第index-1个元素
            node=node.next;
            j++;
        }
        Node sert=new Node(obj);//被插入的结点
        sert.next=node.next;
        node.next=sert;
        return head;
    }

    @Setter
    @Getter
    public static class Node {
        public Node next;
        public int data;

        public Node(int data) {
            this.data = data;
        }
    }
}
