package com.abin.lee.algorithm.leetcode.tree;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.Stack;

/**
 * Created by abin on 2018/9/12.
 * 101. Symmetric Tree
 * 判断二叉树是否对称，二叉树镜像
 * https://leetcode.com/problems/symmetric-tree/description/
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return (root1.val == root2.val) && isMirror(root1.left, root2.right) && isMirror(root2.right, root1.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        return isMirror2(root, root);
    }

    public boolean isMirror2(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true ;
        if(root1 == null || root2 == null)
            return false ;
        Stack<TreeNode> oneStack = new Stack<>();
        Stack<TreeNode> twoStack = new Stack<>();
        TreeNode oneCur = root1, twoCur = root2;
        while(oneCur != null && twoCur != null || (!oneStack.isEmpty() && !twoStack.isEmpty())){

        }

        return true;
    }

    /**
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     * But the following [1,2,2,null,3,null,3] is not:
     * 1
     * / \
     * 2   2
     * \   \
     * 3    3
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println("root=" + JsonUtil.toJson(root));
        boolean min = new SymmetricTree().isSymmetric(root);
//        boolean min = new SymmetricTree().isSymmetric(root);
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
