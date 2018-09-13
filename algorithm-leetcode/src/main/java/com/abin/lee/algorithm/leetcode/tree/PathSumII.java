package com.abin.lee.algorithm.leetcode.tree;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by abin on 2018/9/13.
 * 113. Path Sum II
 * https://leetcode.com/problems/path-sum-ii/description/
 */
public class PathSumII {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (null == root) return list;
        Stack<Integer> stack = new Stack<>();
        pathSum(root, sum, stack);
        return list;
    }

    public void pathSum(TreeNode root, int sum, Stack<Integer> stack) {
        stack.push(root.val);
        if (root.left != null && root.right != null)
            if (sum == root.val)
                list.add(new ArrayList<>(stack));
        if (root.left != null)
            pathSum(root.left, sum - root.val, stack);
        if (root.right != null)
            pathSum(root.right, sum - root.val, stack);
        stack.pop();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        System.out.println("root=" + JsonUtil.toJson(root));
        List<List<Integer>> list = new PathSumII().pathSum(root, 6);
        System.out.println("list=" + JsonUtil.toJson(list));
    }

    @Setter
    @Getter
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public List<List<Integer>> pathSum3(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs3(root, sum, res, path);
        return res;
    }

    public void dfs3(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (root.val == sum)
                res.add(new ArrayList<Integer>(path));
            return;
        }
        if (root.left != null) {
            dfs3(root.left, sum - root.val, res, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            dfs3(root.right, sum - root.val, res, path);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> pathSum4(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int SUM = 0;
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                path.add(cur.val);
                SUM += cur.val;
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != pre) {
                cur = cur.right;
                continue;
            }
            if (cur.left == null && cur.right == null && SUM == sum)
                res.add(new ArrayList<Integer>(path));

            pre = cur;
            stack.pop();
            path.remove(path.size() - 1);
            SUM -= cur.val;
            cur = null;

        }
        return res;
    }

}
