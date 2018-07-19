package com.qunar.des.algorithm.nowcoder;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/7/19.
 * 两个链表的第一个公共结点
 题目描述
 输入两个链表，找出它们的第一个公共结点。
 160. Intersection of Two Linked Lists
 https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        int len1 = 0;
        while(node1 != null){
            node1 = node1.next ;
            ++len1;
        }
        int len2 = 0;
        while(node2 != null){
            node2 = node2.next ;
            ++len2;
        }
        ListNode node11 = pHead1;
        ListNode node22 = pHead2;
        while(len1 > len2){
            node11 = node11.next ;
            --len1;
        }
        while(len1 < len2){
            node22 = node22.next ;
            len2--;
        }
        while(node11 != node22){
            node11 = node11.next ;
            node22 = node22.next ;
        }
        return node11;
    }



    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        int len1 = 0;
        while(node1 != null){
            node1 = node1.next ;
            ++len1;
        }
        int len2 = 0;
        while(node2 != null){
            node2 = node2.next ;
            ++len2;
        }
        ListNode node11 = headA;
        ListNode node22 = headB;
        while(len1 > len2){
                node11 = node11.next ;
                --len1;
        }
        while(len1 < len2){
                node22 = node22.next ;
            len2--;
        }
        while(node11 != node22){
            node11 = node11.next ;
            node22 = node22.next ;
        }
        return node11;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2 ;
        node2.next = node3 ;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
//        node6.next = node2;

        ListNode node11 = new ListNode(11);
        ListNode node22 = new ListNode(22);
        ListNode node33 = new ListNode(33);
        node11.next = node22 ;
        node22.next = node33 ;
        node33.next = node3 ;

        ListNode result = new FindFirstCommonNode().getIntersectionNode(node1, node11);
//        ListNode result = new FindFirstCommonNode().getIntersectionNode1(node1, node11);
        System.out.println("result="+ JsonUtil.toJson(result));



    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
