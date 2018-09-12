package com.abin.lee.algorithm.leetcode.tree;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by abin on 2018/9/12.
 * 145. Binary Tree Postorder Traversal
 https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        while(current != null || !stack.isEmpty()){
            if(current != null){
                list.addFirst(current.val);
                stack.push(current);
                current = current.right;
            }else{
                TreeNode node = stack.pop();
                current = node.left;
            }
        }
        return list;
    }

    /**
     * Given a binary tree, return the postorder traversal of its nodes' values.
     Example:
     Input: [1,null,2,3]
     1
     \
     2
     /
     3

     Output: [3,2,1]
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
//        List<Integer> list1 = new BinaryTreePostorderTraversal().postorderTraversal(treeNode1);
        List<Integer> list1 = new BinaryTreePostorderTraversal().postorderTraversal(treeNode1);
        System.out.println("list1=" + JsonUtil.toJson(list1));
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



