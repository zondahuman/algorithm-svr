package com.abin.lee.algorithm.leetcode.tree;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.*;

/**
 * Created by abin on 2018/9/1.
 * 二叉树的中序遍历
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 * https://www.cnblogs.com/grandyang/p/4297300.html
 */
public class BinaryTreeInorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorderTraversal(root, list);
        return list;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (null != root) {
            if (null != root.left)
                inorderTraversal(root.left, list);
            list.add(root.val);
            if (null != root.right)
                inorderTraversal(root.right, list);
        }
    }


    public List<Integer> inorderTraversalLoop(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
        return list;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }


    public List<Integer> inorderTraversal5(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);  // Add after all left children
                p = node.right;
            }
        }
        return result;
    }

    /**
     * Input: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * Output: [1,3,2]
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
//        List<Integer> list = new BinaryTreeInorderTraversal().inorderTraversal(treeNode1);
//        System.out.println("list=" + JsonUtil.toJson(list));
//        List<Integer> list1 = new BinaryTreeInorderTraversal().inorderTraversalLoop(treeNode1);
        List<Integer> list1 = new BinaryTreeInorderTraversal().inorderTraversal2(treeNode1);
        System.out.println("list1=" + JsonUtil.toJson(list1));
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
