package com.qunar.des.algorithm.leetcode.graph.direct;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abin on 2018/6/30.
 * https://leetcode.com/problems/all-paths-from-source-to-target/solution/
 * 图算法之求两点之间的所有路径(java)
 */
public class AllPathsPassByGraph {

    public static void main(String[] args) {
        int[][] graph = {
                {1,0,0,1},
                {0,1,0,0},
                {0,0,1,0},
                {0,0,0,1}
        };
        List<List<Integer>> list = allPathsSourceTarget(graph);
        System.out.println("list="+ JsonUtil.toJson(list));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return solve(graph, 0);
    }

    public static List<List<Integer>> solve(int[][] graph, int node) {
        int N = graph.length;
        List<List<Integer>> ans = new ArrayList();
        if (node == N - 1) {
            List<Integer> path = new ArrayList();
            path.add(N-1);
            ans.add(path);
            return ans;
        }

        for (int nei: graph[node]) {
            for (List<Integer> path: solve(graph, nei)) {
                path.add(0, node);
                ans.add(path);
            }
        }
        return ans;
    }

}
