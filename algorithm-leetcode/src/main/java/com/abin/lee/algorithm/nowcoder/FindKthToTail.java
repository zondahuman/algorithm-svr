package com.abin.lee.algorithm.nowcoder;

/**
 * Created by abin on 2018/7/18.
 */
public class FindKthToTail {

    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null)
            return  null;
        ListNode fast = head ;
        int temp = 0;
        while(null!=fast){
            if(temp == k)
                break;
            fast = fast.next;
            temp++;
        }
        if(temp < k)
            return null;
        ListNode slow = head ;
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }




    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
