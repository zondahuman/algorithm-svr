package com.qunar.des.algorithm.nowcoder;

/**
 * Created by abin on 2018/7/19.
 * 二叉树的深度
 题目描述
 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 104. Maximum Depth of Binary Tree
 https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
public class BinaryTreeDepth {
    public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) +1;
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
