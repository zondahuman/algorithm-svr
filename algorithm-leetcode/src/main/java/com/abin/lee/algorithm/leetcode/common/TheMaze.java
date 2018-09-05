package com.abin.lee.algorithm.leetcode.common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by abin on 2018/9/5.
 * 490. The Maze
 * https://blog.csdn.net/zshouyi/article/details/72974343
 * https://segmentfault.com/a/1190000008323436
 */
public class TheMaze {
    /**
     * 又是图的遍历问题，就是简单的遍历，所以dfs和bfs都可以做，复杂度也是一样的。这道题要求球不能停下来，即使碰到destination，
     * 必须是碰到wall才能停下来。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] maze1 = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = new int[]{0, 4};
//        int[] destination = new int[]{4, 4};
        int[] destination = new int[]{3, 2};
        boolean flag = new TheMaze().hasPath(maze1, start, destination);
        System.out.println("flag=" + flag);

    }


    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length; //行数
        int n = maze[0].length; //列数
        boolean[][] visited = new boolean[m][n];
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(start[0], start[1]));
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int[] dir : dirs) {
                int xx = p.x, yy = p.y;
                while (xx >= 0 && yy >= 0 && xx < m && yy < n && maze[xx][yy] == 0) {
                    xx += dir[0];
                    yy += dir[1];
                }
                xx -= dir[0];
                yy -= dir[1];
                if (visited[xx][yy]) {
                    continue;
                }
                visited[xx][yy] = true;
                if (xx == destination[0] && yy == destination[1]) {
                    return true;
                }
                queue.offer(new Point(xx, yy));
            }
        }
        return false;
    }

    class Point {
        int x;
        int y;

        public Point(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

}
