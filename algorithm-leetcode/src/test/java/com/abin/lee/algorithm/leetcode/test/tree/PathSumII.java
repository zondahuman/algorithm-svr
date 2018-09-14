package com.abin.lee.algorithm.leetcode.test.tree;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abin on 2018/9/14.
 * 113. Path Sum II
 * https://leetcode.com/problems/path-sum-ii/description/
 * 前序遍历
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        pathSum(root, sum, res, list);
        return res;
    }

    public void pathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(list));
        }
        pathSum(root.left, sum, res, list);
        pathSum(root.right, sum, res, list);
        list.remove(list.size() - 1);


    }

    /**
     * 1
     * /     \
     * 2        3
     * /   \     /  \
     * 3      2  2    4
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        System.out.println("root=" + JsonUtil.toJson(root));
        List<List<Integer>> list = new PathSumII().pathSum(root, 6);
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



    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        pathSum2(root, sum, res, list);
        return res;
    }

    public void pathSum2(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(list));
        }
        pathSum2(root.left, sum, res, list);
        pathSum2(root.right, sum, res, list);
        System.out.println();
        System.out.println("before sum= " + sum + " , list=" + JsonUtil.toJson(list));
        list.remove(list.size() - 1);
        System.out.println("after sum= " + sum + " , list=" + JsonUtil.toJson(list));
        System.out.println();


    }

}
