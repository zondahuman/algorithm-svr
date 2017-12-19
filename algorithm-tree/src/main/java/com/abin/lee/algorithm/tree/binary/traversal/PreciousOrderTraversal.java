package com.abin.lee.algorithm.tree.binary.traversal;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by abin on 2017/12/17 2017/12/17.
 * algorithm-svr
 * com.abin.lee.algorithm.tree.binary.traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/discuss/
 * Binary Tree Preorder Traversal
 */
public class PreciousOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        List<Integer> list = preTraversal(root);
        List<Integer> list = preOrderTraversal(root);
        System.out.println("list-="+ JsonUtil.toJson(list));
    }

    public static List<Integer> preTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(null != node){
                list.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return list;
    }


    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        preTraversal(root, list);
        return list;
    }

    public static void preTraversal(TreeNode root, List<Integer> list) {
            if(null != root){
                list.add(root.val);
                preTraversal(root.left, list);
                preTraversal(root.right, list);
            }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
