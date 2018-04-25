package com.abin.lee.algorithm.chain.single.list.basic.find;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-10 下午11:19
 */
public class SingleList {
    private Node header;

    public void addFirst(String data) {
        Node current = new Node(data);
        current.next = header;
        header = current;
    }

    public Node find(int index) {
        Node current = header;
        int i = 0;
        while (null != current) {
            if (i == index) {
                return current;
            } else {
                current = current.next;
            }
            i++;
        }
        return null;
    }

    public Node find(String target) {
        Node current = header;
        while (null != current) {
            if (target == current.data) {
                return current;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addFirst("a");
        singleList.addFirst("b");
        singleList.addFirst("c");
        singleList.addFirst("d");
        singleList.addFirst("e");
        System.out.println("singleList=" + JsonUtil.toJson(singleList.header));
        Node findNode = singleList.find(3);
        System.out.println("findNode=" + JsonUtil.toJson(findNode));
        Node findValueNode = singleList.find("d");
        System.out.println("findValueNode=" + JsonUtil.toJson(findValueNode));
    }
}
