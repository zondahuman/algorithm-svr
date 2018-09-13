package com.abin.lee.algorithm.leetcode.tree;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by abin on 2018/9/13.
 * 700. Search in a Binary Search Tree
 https://leetcode.com/problems/search-in-a-binary-search-tree/description/
 */
public class SearchInABinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                if(node.val == val)
                    return node;
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return null;
    }
    public TreeNode searchBST2(TreeNode root, int val) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null){
                if(node.val == val)
                    return node;
                if(node.left != null)
                    stack.push(node.left);
                if(node.right != null){
                    stack.push(node.right);
                }
            }
        }
        return null;
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
