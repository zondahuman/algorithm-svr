package com.abin.lee.algorithm.nowcoder;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by abin on 2018/7/19.
 * 从上往下打印二叉树
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {

    public ArrayList<Integer> PrintFromTopToBottom1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode last = root;     //当前行的最后节点
        TreeNode nextLast = root;   //下一行的最右节点
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.val + " ");
            list.add(temp.val);
            if (temp.left != null) {
                stack.push(temp.left);
                nextLast = temp.left;
            }
            if (temp.right != null) {
                stack.push(temp.right);
                nextLast = temp.right;
            }
            if (temp == last) {
                System.out.println("");
                last = nextLast;
            }
        }
        return list;
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (null == root)
            return list;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.pop();
            list.add(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return list;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


}
