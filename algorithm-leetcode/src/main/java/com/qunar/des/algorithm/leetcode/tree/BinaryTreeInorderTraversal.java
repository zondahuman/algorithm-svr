package com.qunar.des.algorithm.leetcode.tree;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

import java.util.ArrayList;
import java.util.List;

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



    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        List<Integer> list = new BinaryTreeInorderTraversal().inorderTraversal(treeNode1);
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
