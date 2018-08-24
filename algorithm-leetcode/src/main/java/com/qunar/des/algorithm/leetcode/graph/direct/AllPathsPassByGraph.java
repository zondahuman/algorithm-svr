package com.qunar.des.algorithm.leetcode.graph.direct;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abin on 2018/6/30.
 * https://leetcode.com/problems/all-paths-from-source-to-target/solution/
 * 图算法之求两点之间的所有路径(java)
 * https://blog.csdn.net/fuxuemingzhu/article/details/79624149
 * https://blog.csdn.net/qq_21752135/article/details/79977390
 */
public class AllPathsPassByGraph {

    /**
     * Input: [[1,2], [3], [3], []]
     Output: [[0,1,3],[0,2,3]]

     Explanation: The graph looks like this:

     0--->1
     |    |
     v    v
     2--->3

     There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
     Note:

     The number of nodes in the graph will be in the range [2, 15].
     You can print different paths in any order, but you should keep the order of nodes inside one path.
     题目大意
     给出了一个有向无环图，求从起点到终点的所有路径。图的表示方法是，共有n个节点，其数字分别为0…n-1，给出的图graph的每个位置对应的是第i个节点能到达的下一个节点的序号位置。
     比如题中graph[0] = [1,2]表示图的起点0指向了1,2两个节点。

     解题方法
     经典的dfs的题目啊，第一遍没做这个题的原因是没看懂题目。。
     直接使用dfs的模板公式即可，要注意的是给出的path默认就带着起点0，每次添加的是下个节点n不是当前节点pos。停止的条件是 pos == len(graph) - 1。
     * @param args
     */
    public static void main(String[] args) {
//        int[][] graph = {
//                {1,0,0,1},
//                {0,1,0,0},
//                {0,0,1,0},
//                {0,0,0,1}
//        };
        int[][] graph = {{1,2}, {3}, {3}, {}};
//        int[][] graph = {{1,2}, {3,4}, {5}, {}};
        List<List<Integer>> list = allPathsSourceTarget(graph);
//        List<List<Integer>> list = allPathsSourceTarget1(graph);
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


    public static List<List<Integer>> allPathsSourceTarget1(int[][] graph) {
        return solve1(graph, 0);
    }

    public static List<List<Integer>> solve1(int[][] graph, int node) {
        int N = graph.length;
        List<List<Integer>> ans = new ArrayList();
        if (node == N - 1) {
            List<Integer> path = new ArrayList();
            path.add(N-1);
            ans.add(path);
            return ans;
        }

        for (int nei: graph[node]) {
            for (List<Integer> path: solve1(graph, nei)) {
                path.add(0, node);
                ans.add(path);
            }
        }
        return ans;
    }

}
