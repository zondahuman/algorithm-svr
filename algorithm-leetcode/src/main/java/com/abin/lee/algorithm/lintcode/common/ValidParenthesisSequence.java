package com.abin.lee.algorithm.lintcode.common;

import java.util.Stack;

/**
 * Created by abin on 2018/8/24.
 * Lint-code-有效的括号序列
 * https://blog.csdn.net/dancheren/article/details/56852986
 * https://www.lintcode.com/problem/valid-parentheses/description
 */
public class ValidParenthesisSequence {

    public boolean isValidParentheses(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<Character>();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    flag = false;
                    break;
                }
            } else if (s.charAt(i) == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    flag = false;
                    break;
                }
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    flag = false;
                    break;
                }
            }
        }
        if (!stack.isEmpty())
            flag = false;
        return flag;
    }

    public static void main(String[] args) {
        String param = "()";
        boolean flag = new ValidParenthesisSequence().isValidParentheses(param);
        System.out.println("flag=" + flag);
    }


}
