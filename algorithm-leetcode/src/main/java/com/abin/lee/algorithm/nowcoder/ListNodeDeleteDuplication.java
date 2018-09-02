package com.abin.lee.algorithm.nowcoder;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/7/30.
 * 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * https://www.nowcoder.com/profile/320158/codeBookDetail?submissionId=1501127
 */
public class ListNodeDeleteDuplication {

    public ListNode deleteDuplication(ListNode pHead) {
        ListNode result;
        ListNode temp = pHead;
        ListNode index = new ListNode(0);
        index.next = pHead ;
        result = index;
        while(temp != null){
            if(temp.next != null && temp.next.val == temp.val){
                while(temp.next != null && temp.next.val == temp.val){
                    temp = temp.next ;
                }
                temp = temp.next;
                index.next = temp;
            }else{
                index = index.next;
                temp = temp.next;
            }
        }
        return result.next;
    }

    /**
     * 链表1->2->3->3->4->4->5 处理后为 1->2->5
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        System.out.println("listNode1=" + JsonUtil.toJson(listNode1));
        ListNode result = new ListNodeDeleteDuplication().deleteDuplication(listNode1);
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
