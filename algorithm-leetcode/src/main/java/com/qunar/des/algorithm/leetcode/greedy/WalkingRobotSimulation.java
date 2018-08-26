package com.qunar.des.algorithm.leetcode.greedy;

/**
 * Created by abin on 2018/8/26.
 */
public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {

        return 0;
    }


    public static void main(String[] args) {
        int[] commands = new int[]{5, 5, 5, 10, 20};
        int[][] obstacles = new int[][]{{5, 5, 10}};
        int result = new WalkingRobotSimulation().robotSim(commands, obstacles);
        System.out.println("result=" + result);
    }

}
