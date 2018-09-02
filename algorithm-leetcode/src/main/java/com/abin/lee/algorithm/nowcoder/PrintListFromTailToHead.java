package com.abin.lee.algorithm.nowcoder;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by abin on 2018/7/18.
 * 题目描述
 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
 https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class PrintListFromTailToHead {
    ArrayList<Integer> result = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHeadRecursive(ListNode listNode) {
       if(listNode == null)
           return result;
        printListFromTailToHeadRecursive(listNode.next);
        result.add(listNode.val);
        return result;
    }



    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        ListNode node = listNode;
        while(null != node){
            stack.push(node.val);
            node = node.next;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
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

//        List<Integer> result = printListFromTailToHead(listNode1);
//        System.out.println("result=" + JsonUtil.toJson(result));

        List<Integer> result1 = new PrintListFromTailToHead().printListFromTailToHeadRecursive(listNode1);
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
