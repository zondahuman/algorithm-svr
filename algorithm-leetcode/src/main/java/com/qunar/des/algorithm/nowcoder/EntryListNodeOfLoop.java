package com.qunar.des.algorithm.nowcoder;

/**
 * Created by abin on 2018/7/30.
 * 链表中环的入口结点
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryListNodeOfLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead ;
        ListNode fast = pHead ;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                slow = pHead;
                while (slow != fast){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
