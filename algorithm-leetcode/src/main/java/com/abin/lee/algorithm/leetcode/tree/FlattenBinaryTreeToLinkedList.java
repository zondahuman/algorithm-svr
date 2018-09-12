package com.abin.lee.algorithm.leetcode.tree;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.List;

/**
 * Created by abin on 2018/9/12.
 * 114. Flatten Binary Tree to Linked List
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 * 此题的大概意思就是原地的把二叉树按先序遍历序列串起来。
 * https://blog.csdn.net/my_jobs/article/details/47667289
 * https://blog.csdn.net/pistolove/article/details/42744919
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        while(root != null) {
            if (root.left != null) {
                TreeNode current = root.left;
                while (current.right != null) {
                    current = current.right;
                }
                current.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    public void flatten2(TreeNode root) {
        if(root != null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null ;

        flatten2(left);
        flatten2(right);

        root.right = left;
        TreeNode current = root;
        while(current.right != null)
            current = current.right;
        current.right = root.right;
    }

    /**
     * Given a binary tree, flatten it to a linked list in-place.
     * For example,
     * Given
     * 1
     * / \
     * 2   5
     * / \   \
     * 3   4   6
     * The flattened tree should look like:
     * 1
     * \
     * 2
     * \
     * 3
     * \
     * 4
     * \
     * 5
     * \
     * 6
     * 思路：

     （1）题意为将给定的二叉树转化为“只有右孩子节点”的链表（树）。

     （2）由上图可知，如果右子树不为空，则右子树最后肯定为左子树最有一个靠右的孩子节点的右子树，而左子树最后成为整棵树的右子树。
     这样，首先判断左子树是否为空，不为空就寻找到树根的左孩子节点，然后寻找该节点是否有右孩子，如果有继续寻找，
     直到找到属于叶子节点的右孩子，此时，该节点的右子树“指向”当前树的右子树，并将当前左子树变为树根的右孩子，将整棵树左孩子置为空。
     最后，根节点“指向”根节点的右孩子，继续上述操作，直到整棵树遍历完即得到结果。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.right  = new TreeNode(6);

//        new FlattenBinaryTreeToLinkedList().flatten(root);
        new FlattenBinaryTreeToLinkedList().flatten2(root);
        System.out.println("root=" + JsonUtil.toJson(root));
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
