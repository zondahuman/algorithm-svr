package com.qunar.des.algorithm.leetcode.list;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/8/5.
 * 判断是否为回文链表
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/description/
 * https://blog.csdn.net/u012249528/article/details/47124771
 */
public class PalindromeLinkedList {
    /**
     * 示例 1:
     输入: 1->2
     输出: false

     示例 2:
     输入: 1->2->2->1
     输出: true
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reverse = slow;
        ListNode previous = null;
        while (reverse != null) {
            ListNode next = reverse.next;
            reverse.next = previous;
            previous = reverse;
            reverse = next;
        }
        slow = head;
        while(previous != null){
            if(previous.val != slow.val)
                return false;
            previous = previous.next;
            slow = slow.next;
        }
        return true;
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

        int four = 3;
        int five = 2;
        int six = 1;
        ListNode listNode11 = new ListNode(four);
        ListNode listNode22 = new ListNode(five);
        ListNode listNode33 = new ListNode(six);
        listNode3.next = listNode11;
        listNode11.next = listNode22;
        listNode22.next = listNode33;

        int seven = 7;
        ListNode listNode111 = new ListNode(seven);
//        listNode33.next = listNode111;
        System.out.println("listNode1=" + JsonUtil.toJson(listNode1));

        boolean result = new PalindromeLinkedList().isPalindrome(listNode1);
//        ListNode result = new PalindromeLinkedList().middleNode(listNode1);
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
