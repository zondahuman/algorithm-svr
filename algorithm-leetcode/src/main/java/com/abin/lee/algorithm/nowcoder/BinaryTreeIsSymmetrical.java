package com.abin.lee.algorithm.nowcoder;

/**
 * Created by abin on 2018/7/27.
 * 对称的二叉树
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class BinaryTreeIsSymmetrical {

    public static void main(String[] args) {

    }

    boolean isSymmetrical1(TreeNode pRoot) {
        if (null == pRoot)
            return true;
        return isSymmetrical1(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical1(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val)
            return isSymmetrical1(left.left, right.right) && isSymmetrical1(left.right, right.left);
        return false;
    }

    boolean isSymmetrical(TreeNode pRoot) {
        TreeNode node = getMirror(pRoot);
        return isSymmetrical(pRoot, node);
    }

    boolean isSymmetrical(TreeNode pRoot, TreeNode node) {
        if (node == null && pRoot == null) {
            return true;
        } else if (node == null || pRoot == null) {
            return false;
        }
        if (node.val == pRoot.val)
            return isSymmetrical(pRoot.left, node.left) && isSymmetrical(pRoot.right, node.right);
        return false;
    }


    public TreeNode getMirror(TreeNode pRoot) {
        if (null == pRoot)
            return null;
        TreeNode root = new TreeNode(pRoot.val);
        root.left = getMirror(pRoot.left);
        root.right = getMirror(pRoot.right);
        return root;
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
