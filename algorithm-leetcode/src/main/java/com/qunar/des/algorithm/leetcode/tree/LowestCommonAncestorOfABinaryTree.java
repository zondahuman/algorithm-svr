package com.qunar.des.algorithm.leetcode.tree;

/**
 * Created by abin on 2018/9/2.
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)
            return root;
        return left == null ? right : left;
    }

    /**
     * 如果转换成代码的话，从上往下走，base case分为3种，判断遇到了p就直接返回p，遇到q就直接返回q，不用向下做了。如果left,right都不为空，
     * 就返回root自己；left,right哪一个不为空就返回哪个，整个recursion做完就可以得到LCA。
     * https://segmentfault.com/a/1190000009429876
     * @param args
     */
    public static void main(String[] args) {

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
