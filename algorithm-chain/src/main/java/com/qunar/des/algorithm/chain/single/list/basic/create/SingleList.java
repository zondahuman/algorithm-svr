package com.qunar.des.algorithm.chain.single.list.basic.create;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-10 下午4:45
 */
public class SingleList {
    private Node header;

    public void addFirst(int data) {
        Node current = new Node(data);
        current.next = header;
        header = current;
    }

    public void addLast(int data) {
        Node current = header;
        while (null != current.next) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void addAny(int index, int data) {
        Node current = header;
        int i = 0;
        while (null != current) {
            if (i == index-1) {
                Node node = new Node(data);
                node.next = current.next;
                current.next = node;
                break;
            } else {
                current = current.next;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addFirst(1);
        singleList.addFirst(2);
        singleList.addFirst(3);
//        singleList.addFirst(4);
//        singleList.addFirst(5);
//        singleList.addFirst(6);
        System.out.println("singleList=" + JsonUtil.toJson(singleList.header));
//        singleList.addLast(7);
//        System.out.println("singleList=" + JsonUtil.toJson(singleList.header));
        singleList.addAny(1, 9);
        System.out.println("singleList=" + JsonUtil.toJson(singleList.header));
    }
}
