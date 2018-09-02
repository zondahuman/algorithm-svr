package com.abin.lee.algorithm.nowcoder;

import java.util.Stack;

/**
 * Created by abin on 2018/7/17.
 */
public class TwoStackAchieveQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop(){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }


}
