package com.abin.lee.algorithm.special.basic.maze;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by abin on 2018/9/6.
 */
public class CreateMaze {

    public static void main(String[] args) {
        int[][] maze1 = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        int[] start = new int[]{0, 0};
        int[] destination = new int[]{4, 4};
//        int[] destination = new int[]{3, 2};
//        boolean flag = new CreateMaze().createMaze(maze1, start, destination);
        boolean flag = new CreateMaze().createMaze1(maze1, start, destination);
        System.out.println("flag=" + flag);
        System.out.println("maze1=" + JsonUtil.toJson(maze1));
    }

    public boolean createMaze(int[][] maze, int[] start, int[] destination) {
        int m = maze.length; //行数
        int n = maze[0].length; //列数
        boolean[][] visited = new boolean[m][n];
        Stack<Point> stack = new Stack<Point>();
        stack.push(new Point(start[0], start[1]));
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!stack.isEmpty()) {
            Point point = stack.pop();
            for (int[] dir : dirs) {
                int xx = point.x, yy = point.y;
                while (xx >= 0 && yy >= 0 && xx < m && yy < n && maze[xx][yy] == 0) {
                    xx += dir[0];
                    yy += dir[1];
                }
                xx -= dir[0];
                yy -= dir[1];
                if (xx < 0 || xx >= m || yy < 0 || yy >= n || visited[xx][yy] == true) {
                    continue;
                }
                visited[xx][yy] = true;
                if (maze[xx][yy] != 1) {
                    maze[xx][yy] = 1;
                    if (xx == destination[0] && yy == destination[1]) {
                        return true;
                    }
                    stack.push(new Point(xx, yy));
                }

            }
        }
        return false;
    }

    public boolean createMaze1(int[][] maze, int[] start, int[] destination) {
        int m = maze.length; //行数
        int n = maze[0].length; //列数
        Stack<Point> stack = new Stack<Point>();
        stack.push(new Point(start[0], start[1]));
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!stack.isEmpty()) {
            Point point = stack.pop();
            int xx = point.x, yy = point.y;
            if (maze[xx][yy] != 1) {
                maze[xx][yy] = 1;
            }
            if (xx >= 0 && yy >= 0 && xx < m && yy < n && maze[xx][yy] == 1) {
                int[] dir = dirs[(int) Math.random() * 4];
                xx += dir[0];
                yy += dir[1];
                if (xx >= m)
                    xx = m - 1;
                if (yy >= n)
                    xx = n - 1;
                stack.push(new Point(xx, yy));
            }
            if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
                for (int[] dir :dirs) {
                    xx += dir[0];
                    yy += dir[1];
                }
//                if(){
//
//                }
                continue;
            }
            if ((maze[xx][yy] == 1 && xx == 0) && (maze[xx][yy] == 1 && yy == 0) && (maze[xx][yy] == 1 && xx == m - 1) && (maze[xx][yy] == 1 && yy == n - 1)) {
                maze[xx][yy] = 0;
                if (!stack.isEmpty()) {
//                        Point point2 = stack.pop();
//                        xx = point2.x;
//                        yy = point2.y;
                    continue;
                }
            }
            if (xx == destination[0] && yy == destination[1]) {
                return true;
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


    @Test
    public void test1() {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int random = (int) (Math.random() * 4);
        int[] dir = dirs[random];
        System.out.println("dir=" + JsonUtil.toJson(dir) + " ,random=" + random);

        int xx = dir[0];
        int yy = dir[1];
        System.out.println("xx=" + xx + " ,yy=" + yy);
    }

}
