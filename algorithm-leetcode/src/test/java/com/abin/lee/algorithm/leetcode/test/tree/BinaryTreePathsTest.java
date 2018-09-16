package com.abin.lee.algorithm.leetcode.test.tree;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by abin on 2018/9/16.
 */
public class BinaryTreePathsTest {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (null == root) return list;
        Stack<TreeNode> treeStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        treeStack.push(root);
        strStack.push("");
        while (!treeStack.isEmpty()) {
            TreeNode node = treeStack.pop();
            String str1 = strStack.pop();
            if (node.left == null && node.right == null) {
                list.add(str1 + node.val);
            }
            if (node.left != null) {
                treeStack.push(node.left);
                strStack.push(str1 + node.val + "->");
            }
            if (node.right != null) {
                treeStack.push(node.right);
                strStack.push(str1 + node.val + "->");
            }
        }
        return list;
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> list = new ArrayList<>();
        binaryTreePathsTravser(root, list);
        return list;
    }

    public void binaryTreePathsTravser(TreeNode root, List<String> list) {
        if (root == null) return;
        if (root.left == null && root.right != null)
            list.add(root.val + "");
        binaryTreePathsTravser(root.left, list);
        binaryTreePathsTravser(root.right, list);
    }

    /**
     * Input:
     * 1
     * /   \
     * 2     3
     * \
     * 5
     * Output: ["1->2->5", "1->3"]
     * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
//        List<String> list = new BinaryTreePathsTest().binaryTreePaths(root);
        List<String> list = new BinaryTreePathsTest().binaryTreePaths2(root);
        System.out.println("list=" + JsonUtil.toJson(list));
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
