package com.abin.lee.algorithm.chain.single.list.basic.common;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/4/28 18:43.
 * algorithm-svr
 * com.abin.lee.algorithm.chain.single.list.basic.common
 */
public class SingListCommon {
    /**
     * 是否有环
     * @param root
     * @return
     */
    public static boolean haveRing(Node root){
        Node current = root ;

        return false;
    }

    /**
     *
     * @param root
     * @return
     */
    public static boolean checkCross(Node root){
        Node current = root ;
        Node previous = root;
        Node slow = root ;
        Node fast = root ;
        while(fast != null && fast.next != null){
            slow = root.next;
            fast = root.next.next;
        }
        return false;
    }


    public static Node reverseNode(Node root){
        Node current = root ;
        Node previous = null;
        while(current != null){
            Node next = current.next;
            current.next = previous;
            previous = current ;
            current = next;
        }
        return previous;
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2 ;
        node2.next = node3 ;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println("node1 = " + JsonUtil.toJson(node1));
        Node reverseNode = reverseNode(node1);
        System.out.println("reverseNode = " + JsonUtil.toJson(reverseNode));

        node6.next = node2;
        boolean result = haveRing(node1);
        System.out.println("result = " + result);
//        Node entrance = ringEntrance(node1);
//        System.out.println("entrance = " + entrance.data);
//        int ringlength = ringlength(node1);
//        System.out.println("ringlength = " + ringlength);
    }



    public static class Node {
        public int data;
        public Node next;
        public Node(int data){
            this.data = data;
        }
    }

}
