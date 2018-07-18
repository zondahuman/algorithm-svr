package com.qunar.des.algorithm.nowcoder;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

import java.util.List;

/**
 * Created by abin on 2018/7/18.
 * 反转链表
 题目描述
 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseSingleList {

    public ListNode ReverseList(ListNode head) {
        ListNode current = head ;
        ListNode previous = null;
        while(current != null){
            ListNode next = current.next ;
            current.next = previous ;
            previous = current ;
            current = next;
        }
        return previous;
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

        System.out.println("listNode1=" + JsonUtil.toJson(listNode1));
        ListNode result1 = new ReverseSingleList().ReverseList(listNode1);
        System.out.println("result1=" + JsonUtil.toJson(result1));

    }



    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
