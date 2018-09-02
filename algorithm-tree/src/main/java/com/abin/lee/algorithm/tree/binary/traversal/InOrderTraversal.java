package com.abin.lee.algorithm.tree.binary.traversal;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by abin on 2017/12/17 2017/12/17.
 * algorithm-svr
 * com.abin.lee.algorithm.tree.binary.traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * http://www.lintcode.com/zh-cn/problem/binary-tree-inorder-traversal/
 * Binary Tree Inorder Traversal
 */
public class InOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
//        List<Integer> list = inTraversal(root);
        List<Integer> list = inorderTraversal(root);
        System.out.println("list-=" + JsonUtil.toJson(list));
    }

    public static List<Integer> inTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (null == root) return list;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (null != current || !stack.isEmpty()) {
            while (null != current) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
        return list;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // method 1: recursion

        helper(root, res);
        return res;
    }

    //helper function for method 1
    private static void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
