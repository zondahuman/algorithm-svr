package com.abin.lee.algorithm.leetcode.tree;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by abin on 2018/9/13.
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */
public class LowestCommonAncestorBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            lowestCommonAncestor(root.left, p, q);
        } else if (p != null && q != null && p.val > root.val && q.val > root.val) {
            lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    /**
     * 如果如果p,q 比root小, 则LCA必定在左子树, 如果p,q比root大, 则LCA必定在右子树. 如果一大一小, 则root即为LCA.
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);
        System.out.println("root=" + JsonUtil.toJson(root));
        TreeNode treeNode = new LowestCommonAncestorBinarySearchTree().lowestCommonAncestor(root, root.right.left, root.right.right);
        System.out.println("treeNode=" + JsonUtil.toJson(treeNode));

    }

    @Getter
    @Setter
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
