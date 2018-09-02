package com.qunar.des.algorithm.nowcoder;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/7/19.
 * 合并两个排序的链表
 * 题目描述
 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeTwoSortedList {

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode result = new ListNode(0);
//        while(){
//
//        }
        return null;
    }
    public ListNode Merge1(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        if(list1.val < list2.val) {
            list1.next = Merge1(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge1(list1, list2.next) ;
            return list2;
        }
    }

    public ListNode Merge2(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        ListNode pMergeHead = null;
        if(list1.val<list2.val){
            pMergeHead = list1;
            pMergeHead.next = Merge2(list1.next,list2);
        }else{
            pMergeHead = list2;
            pMergeHead.next = Merge2(list1,list2.next);
        }
        return pMergeHead;
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

//        ListNode result1 = new MergeTwoSortedList().Merge1(listNode1, listNode11);
//        System.out.println("result1=" + JsonUtil.toJson(result1));
        ListNode result2 = new MergeTwoSortedList().Merge2(listNode1, listNode11);
        System.out.println("result2=" + JsonUtil.toJson(result2));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
