package com.qunar.des.algorithm.leetcode.list;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/8/5.
 * 237. Delete Node in a Linked List
 https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 */
public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {

    }

    public static void main(String[] args) {
        int one = 6;
        int two = 6;
        int three = 2;
        ListNode listNode1 = new ListNode(one);
        ListNode listNode2 = new ListNode(two);
        ListNode listNode3 = new ListNode(three);
//        listNode1.next = listNode2;
        listNode2.next = listNode3;

        int four = 3;
        int five = 4;
        int six = 6;
        ListNode listNode11 = new ListNode(four);
        ListNode listNode22 = new ListNode(five);
        ListNode listNode33 = new ListNode(six);
        listNode3.next = listNode11;
        listNode11.next = listNode22;
        listNode22.next = listNode33;

//        ListNode result = new DeleteNodeInLinkedList().deleteNode(listNode1);
        new DeleteNodeInLinkedList().deleteNode(listNode1);
//        System.out.println("result=" + JsonUtil.toJson(result));
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
