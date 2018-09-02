package com.abin.lee.algorithm.leetcode.list;

/**
 * Created by abin on 2018/8/5.
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/description/
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (null == head)
            return null;
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous ;
            previous = current ;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
