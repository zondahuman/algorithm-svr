package com.qunar.des.algorithm.leetcode.list;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/7/18.
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/discuss/149720/My-Java-solution-easy-understanding
 * https://leetcode.com/problems/merge-two-sorted-lists/discuss/9715/Java-1-ms-4-lines-codes-using-recursion/155913
 */
public class MergeTwoSortedLists {
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
        ListNode result = mergeTwoLists(listNode1, listNode11);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (l1 != null && l2 !=null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            }else  {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next ;
        }
        current.next = l1 == null ? l2 : l1;
        return head.next;
    }


    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
