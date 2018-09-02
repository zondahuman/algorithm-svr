package com.qunar.des.algorithm.leetcode.common;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/5/15 12:58.
 * algorithm-svr
 * com.qunar.des.algorithm.leetcode.common
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2 ;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5 ;
        listNode5.next = listNode6;
        ListNode listNode = new AddTwoNumbers().myAddTwoNumbers(listNode1, listNode4);
        System.out.println("listNode=" + JsonUtil.toJson(listNode));
    }


    public ListNode myAddTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return null;
        }
        StringBuffer stb1 = new StringBuffer();
        while(l1 != null){
            stb1.append(l1.val);
            l1 = l1.next ;
        }
        int num1 = Integer.valueOf(stb1.toString());
        StringBuffer stb2 = new StringBuffer();
        while(l2 != null){
            stb2.append(l2.val);
            l2 = l2.next ;
        }
        int num2 = Integer.valueOf(stb2.toString());
        int total = num1 + num2;
        StringBuffer stb = new StringBuffer(total + "");
        ListNode listNode = new ListNode(0) ;
        String temp = stb.reverse().toString();
        ListNode current = listNode;
        for (int i = 0; i <temp.length() ; i++) {
            current.next = new ListNode(Integer.valueOf(temp.charAt(i)+""));
            current = current.next;
        }
        return listNode;
    }




    /**
     * Definition for singly-linked list.
     *
     */
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }

}
