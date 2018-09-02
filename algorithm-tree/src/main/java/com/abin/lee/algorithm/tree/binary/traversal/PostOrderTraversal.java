package com.abin.lee.algorithm.tree.binary.traversal;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by abin on 2017/12/17 2017/12/17.
 * algorithm-svr
 * com.abin.lee.algorithm.tree.binary.traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 * http://www.lintcode.com/zh-cn/problem/binary-tree-postorder-traversal/
 * Binary Tree postorder Traversal
 */
public class PostOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println("root-="+ JsonUtil.toJson(root));
        List<Integer> list = postTraversal(root);
//        List<Integer> list = postOrderTraversal(root);
        System.out.println("list-="+ JsonUtil.toJson(list));
    }

    public static List<Integer> postTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> leftChildren = new Stack<TreeNode>();
        while(root != null) {
            result.addFirst(root.val);
            if (root.left != null) {
                leftChildren.push(root.left);
            }
            root = root.right;
            if (root == null && !leftChildren.isEmpty()) {
                root = leftChildren.pop();
            }
        }
        return result;
    }

    
    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        preTraversal(root, list);
        return list;
    }

    public static void preTraversal(TreeNode root, List<Integer> list) {
            if(null != root){
                preTraversal(root.left, list);
                preTraversal(root.right, list);
                list.add(root.val);
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
