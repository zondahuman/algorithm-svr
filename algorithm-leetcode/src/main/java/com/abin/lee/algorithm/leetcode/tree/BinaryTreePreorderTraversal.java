package com.abin.lee.algorithm.leetcode.tree;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.*;

/**
 * Created by abin on 2018/9/12.
 * 144. Binary Tree Preorder Traversal
 * 二叉树的先序遍历
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 * https://www.cnblogs.com/grandyang/p/4146981.html
 * 一般我们提到树的遍历，最常见的有先序遍历，中序遍历，后序遍历和层序遍历，它们用递归实现起来都非常的简单。而题目的要求是不能使用递归求解，
 * 于是只能考虑到用非递归的方法，这就要用到stack来辅助运算。由于先序遍历的顺序是"根-左-右", 算法为：
 * <p>
 * 1. 把根节点push到栈中
 * 2. 循环检测栈是否为空，若不空，则取出栈顶元素，保存其值，
 * 然后看其右子节点是否存在，若存在则push到栈中。
 * 再看其左子节点，若存在，则push到栈中。
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (null != node) {
                list.add(node.val);
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal5(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.add(p.val);  // Add before going to children
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;
            }
        }
        return result;
    }


    /**
     * 根--左--右
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//
//        root.right = new TreeNode(5);
//        root.right.right  = new TreeNode(6);

        List<Integer> list = new BinaryTreePreorderTraversal().preorderTraversal(root);
        System.out.println("list=" + JsonUtil.toJson(list));

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
