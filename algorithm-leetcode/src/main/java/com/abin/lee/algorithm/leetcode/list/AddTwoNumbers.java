package com.abin.lee.algorithm.leetcode.list;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/8/5.
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {
    /**
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode11 = new ListNode(5);
        ListNode listNode22 = new ListNode(6);
        ListNode listNode33 = new ListNode(4);
        listNode11.next = listNode22;
        listNode22.next = listNode33;

        System.out.println("listNode1=" + JsonUtil.toJson(listNode1));
        System.out.println("listNode11=" + JsonUtil.toJson(listNode11));

        ListNode result = new AddTwoNumbers().addTwoNumbers(listNode1, listNode11);
//        ListNode result = addTwoNumbers(listNode1, listNode11);
//        ListNode result = addTwoNumbers1(listNode1, listNode11);

        System.out.println("result=" + JsonUtil.toJson(result));

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int count = 0;
        while (l1 != null || l2 != null || count != 0) {
            int one = 0;
            if (l1 != null) {
                one += l1.val;
                l1 = l1.next;
            }
            int two = 0;
            if (l2 != null) {
                two = l2.val;
                l2 = l2.next;
            }
            count = one + two + count;
            cur.next = new ListNode(count % 10);
            count /= 10;
            cur = cur.next;
        }
        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
