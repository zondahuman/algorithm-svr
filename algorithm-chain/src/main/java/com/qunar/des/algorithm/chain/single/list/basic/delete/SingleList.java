package com.qunar.des.algorithm.chain.single.list.basic.delete;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-12 上午2:18
 */
public class SingleList {
    private Node header;

    public void addFirst(int data) {
        Node current = new Node(data);
        current.next = header;
        header = current;
    }

    public Node deleteFirst() {
        Node current = header;
        current = current.next;
        return current;
    }

    public Node deleteLast() {
        Node current = header;
        Node head = new Node(header.data);
        while (null != current.next) {
            head.next = new Node(current.data);
            current = current.next;
        }
        return head;
    }
    public Node deleteAny(int index){

        return null;
    }

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addFirst(1);
        singleList.addFirst(2);
        singleList.addFirst(3);
        System.out.println("singleList=" + JsonUtil.toJson(singleList.header));
        Node deleteFirst = singleList.deleteFirst();
        System.out.println("deleteFirst=" + JsonUtil.toJson(deleteFirst));
        Node deleteLast = singleList.deleteLast();
        System.out.println("deleteLast=" + JsonUtil.toJson(deleteLast));
    }
}
