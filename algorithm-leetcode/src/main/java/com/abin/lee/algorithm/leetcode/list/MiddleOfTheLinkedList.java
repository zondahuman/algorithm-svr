package com.abin.lee.algorithm.leetcode.list;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/8/5.
 * 876. Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 */
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null && fast.next == null) {
            return slow;
        }
        if (fast == null) {
            return slow;
        }
        return null;
    }

    public ListNode middleNode1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int one = 1;
        int two = 2;
        int three = 3;
        ListNode listNode1 = new ListNode(one);
        ListNode listNode2 = new ListNode(two);
        ListNode listNode3 = new ListNode(three);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        int four = 4;
        int five = 5;
        int six = 6;
        ListNode listNode11 = new ListNode(four);
        ListNode listNode22 = new ListNode(five);
        ListNode listNode33 = new ListNode(six);
        listNode3.next = listNode11;
        listNode11.next = listNode22;
        listNode22.next = listNode33;

        int seven = 7;
        ListNode listNode111 = new ListNode(seven);
        listNode33.next = listNode111;
        System.out.println("listNode1=" + JsonUtil.toJson(listNode1));

        ListNode result = new MiddleOfTheLinkedList().middleNode1(listNode1);
//        ListNode result = new MiddleOfTheLinkedList().middleNode(listNode1);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
