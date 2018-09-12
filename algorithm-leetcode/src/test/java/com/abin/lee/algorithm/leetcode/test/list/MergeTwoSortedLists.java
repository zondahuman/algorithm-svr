package com.abin.lee.algorithm.leetcode.test.list;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/9/12.
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (null != l1 && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public static void main(String[] args) {
        int one = 2;
        int two = 5;
        int three = 7;
        ListNode listNode1 = new ListNode(one);
        ListNode listNode2 = new ListNode(two);
        ListNode listNode3 = new ListNode(three);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        int four = 1;
        int five = 6;
        int six = 9;
        ListNode listNode11 = new ListNode(four);
        ListNode listNode22 = new ListNode(five);
        ListNode listNode33 = new ListNode(six);
        listNode11.next = listNode22;
        listNode22.next = listNode33;

//        ListNode result = mergeTwoLists1(listNode1, listNode11);
        ListNode result = new MergeTwoSortedLists().mergeTwoLists(listNode1, listNode11);
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
