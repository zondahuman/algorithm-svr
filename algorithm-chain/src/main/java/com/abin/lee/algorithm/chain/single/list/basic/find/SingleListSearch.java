package com.abin.lee.algorithm.chain.single.list.basic.find;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by abin on 2018/4/1 20:39.
 * algorithm-svr
 * com.qunar.des.algorithm.chain.single.list.basic.find
 */
public class SingleListSearch {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.next = node2 ;
        node2.next = node3 ;
        node3.next = node4 ;
        node4.next = node5 ;
        node5.next = node6 ;
        node6.next = node7 ;

        Node middle = searchMiddle(node1) ;
        System.out.println("middle = " + JsonUtil.toJson(middle));




    }

    public static Node searchMiddle(Node root){
        Node slow = root ;
        Node fast = root ;
        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
        }
        return slow;
    }


    @Setter
    @Getter
    public static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value ;
        }
    }


}
