package com.qunar.des.algorithm.leetcode.tree;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/8/14.
 */
public class MinimumDistanceBetweenBSTNodes {
    int min = Integer.MAX_VALUE;
    TreeNode previous = null;
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return min;
    }

    public void inorder(TreeNode root) {
        if (null == root)
            return;
        inorder(root.left);
        if (null != previous)
            min = Math.min(min, root.val - previous.val);
        previous = root;
        inorder(root.right);
    }


    public static void main(String[] args) throws InterruptedException {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(14);
        System.out.println("root=" + JsonUtil.toJson(root));

        int min = new MinimumDistanceBetweenBSTNodes().minDiffInBST(root);
        System.out.println("min=" + JsonUtil.toJson(min));
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
