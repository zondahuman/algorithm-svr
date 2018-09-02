package com.abin.lee.algorithm.leetcode.bfs;

import java.util.LinkedList;

/**
 * Created by abin on 2018/8/26.
 * 490. The Maze
 * https://leetcode.com/problems/the-maze/
 * https://leetcode.com/articles/the-maze/
 * https://www.jianshu.com/p/eb61a466c556
 */
public class TheMaze {
    /**
     * 迷宫中有一个球，空旷的空间和墙壁。 球可以通过向上，向下，向左或向右滚动来穿过空的空间，但是在撞到墙壁之前它不会停止滚动。
     * 当球停止时，它可以选择下一个方向。
     * 给定球的起始位置，目的地和迷宫，确定球是否可以停在目的地。
     * 迷宫由二进制2D阵列表示。 1表示墙，0表示空白区。 你可以假设迷宫的边界都是墙。 起始坐标和目标坐标由行索引和列索引表示。
     *
     * @param args
     */
    public static void main(String[] args) {
        //pass
//        int[][] mazeIntiail = {
//                {0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0},
//                {0, 0, 0, 1, 0},
//                {1, 1, 0, 1, 1},
//                {0, 0, 0, 0, 0}
//        };
//        int[] start = {0, 4};
//        int[] destination = {4, 4};
        //nopass
        int[][] mazeIntiail = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
        int[] destination = {3, 2};
        boolean flag = new TheMaze().hasPath(mazeIntiail, start, destination);
        System.out.println("flag="+flag);
    }


    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        if (start[0] == destination[0] && start[1] == destination[1]) return true;
        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][] visited = new boolean[m][n];

        LinkedList<Point> queue = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        queue.offer(new Point(start[0], start[1]));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x, y = p.y;
            for (int i = 0; i < 4; i++) {
                int xx = x, yy = y;
                while (xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0) {
                    xx += dir[i][0];
                    yy += dir[i][1];
                }
                xx -= dir[i][0];
                yy -= dir[i][1];
                if (visited[xx][yy]) continue;
                visited[xx][yy] = true;
                if (xx == destination[0] && yy == destination[1]) return true;
                queue.offer(new Point(xx, yy));
            }
        }
        return false;
    }


    public static class Point {
        int x, y;

        public Point(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
}
