package com.abin.lee.algorithm.special.basic.dijkstra;

/**
 * Created by abin on 2018/9/16.
 * Dijkstra算法是典型的用来求最短路径的算法，主要用来计算有向图中从起始点到其他所有点的最短路径.该算法采用贪心的思想，
 * 每次都查找与起始点距离最近的点，并将结果输出.该算法的主要特点是每次迭代的时候选择的下一个顶点是标记点之外距离源点最近的顶点.
 * 一般情况下，该算不能用来解决存在负权边的图。

 */
public class DijkstraMinPath {

    public static void dijkstra(int vs, int[][] graph) {
        if(graph.length == 0)return;
        boolean[] visited = new boolean[graph.length];
        int[] path = new int[graph.length];


    }
}
