package com.abin.lee.algorithm.chain.single.list.basic.common;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/7/1.
 * https://blog.csdn.net/qq_34587892/article/details/76186709
 * https://blog.csdn.net/jingsuwen1/article/details/51355580
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class TwoSingleListSum {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(7);
        listNode1.next = listNode2 ;
        listNode2.next = listNode3 ;

        ListNode listNode11 = new ListNode(9);
        ListNode listNode22 = new ListNode(6);
        ListNode listNode33 = new ListNode(4);
        listNode11.next = listNode22 ;
        listNode22.next = listNode33 ;

        System.out.println("listNode1=" + JsonUtil.toJson(listNode1));
        System.out.println("listNode11=" + JsonUtil.toJson(listNode11));

        ListNode result = twoNumSum(listNode1, listNode11);
//        ListNode result = addTwoNumbers(listNode1, listNode11);
//        ListNode result = addTwoNumbers1(listNode1, listNode11);

        System.out.println("result=" + JsonUtil.toJson(result));

    }
    public static ListNode addTwoNumbers1(ListNode first, ListNode second) {
        if(first==null)
            return second;
        if(second==null)
            return first;

        int sum=0;//first和second对应结点的和，值为（0-9）；
        int carry=0;//first和second对应结点求和后对应的进位，值为（0或1）；

        ListNode head=new ListNode(0);
        ListNode cur=head;


        while(first != null||second != null||carry != 0)
        {
            int num1=0;
            int num2=0;

            if(first!=null)
            {
                num1=first.val;
                first=first.next;
            }
            if(second!=null)
            {
                num2=second.val;
                second=second.next;
            }
            sum=(carry+num1+num2)%10;
            ListNode temp=new ListNode(sum);
            cur.next=temp;
            cur=cur.next;

            carry=(carry+num1+num2)/10;
        }
        return head.next;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode p = new ListNode(0);
        p = listNode;
        int sum = 0;

        while (l1 != null || l2 != null || sum != 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(sum % 10);
            sum = sum / 10;
            p = p.next;
        }
        return listNode.next;
    }

    public static ListNode twoNumSum(ListNode node1, ListNode node2){
        ListNode node = new ListNode(0);
        ListNode current = node;
        int sum = 0;
        while (node1 != null || null != node2 || sum != 0){
            if(node1 != null){
                sum += node1.val ;
                node1 = node1.next ;
            }
            if(node2 != null){
                sum += node2.val ;
                node2 = node2.next ;
            }
            current.next = new ListNode(sum % 10);
            sum = sum / 10;
            current = current.next ;
        }
        return node.next;

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
