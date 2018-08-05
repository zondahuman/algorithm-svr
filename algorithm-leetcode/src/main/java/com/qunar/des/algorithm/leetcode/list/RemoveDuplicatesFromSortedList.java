package com.qunar.des.algorithm.leetcode.list;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/8/5.
 * 83. Remove Duplicates from Sorted List
 https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while(current != null && current.next != null ){
            if(current.val == current.next.val){
                current.next = current.next.next ;
            }else{
                current = current.next;
            }
        }
        return head ;
    }

    public static void main(String[] args) {
        int one = 1;
        int two = 1;
        int three = 2;
        ListNode listNode1 = new ListNode(one);
        ListNode listNode2 = new ListNode(two);
        ListNode listNode3 = new ListNode(three);
        listNode1.next = listNode2;
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

        ListNode result = new RemoveDuplicatesFromSortedList().deleteDuplicates(listNode1);
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
