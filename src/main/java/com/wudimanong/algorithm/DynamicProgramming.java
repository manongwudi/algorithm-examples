package com.wudimanong.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangqiao
 * @desc 动态规划算法示例
 */
public class DynamicProgramming {

    /**
     * @desc 题目：有一座高度是10级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。要求用程序来求出一共有多少种走法。
     * @desc 备忘录算法
     */
    public static int getClimbingWays(int n, HashMap<Integer, Integer> map) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int value = getClimbingWays(n - 1, map) + getClimbingWays(n - 2, map);
            map.put(n, value);
            return value;
        }
    }

    public static int getClimbingWays(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }


    /**
     * @param n
     * @param w
     * @param g
     * @param p
     * @return
     * @desc n-金矿数量；w-工人数；金矿的黄金量-g[];金矿的用金量p[]
     */
    public int getMostGold(int n, int w, int[] g, int[] p) {

        int[] preResults = new int[p.length];
        int[] results = new int[p.length];
        //填充边界格子的值
        for (int i = 0; i <= n; i++) {
            if (i < p[0]) {
                preResults[i] = 0;
            } else {
                preResults[i] = g[0];
            }
        }
        //填充其余格子的值。外层循环是金矿数量，内层循环是工人树
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (j < p[i]) {
                    results[j] = preResults[j];
                } else {
                    results[j] = Math.max(preResults[j], preResults[j - p[i]] + g[i]);
                }
            }
            preResults = results;
        }
        return results[n];
    }


    public static void main(String[] args) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int i = getClimbingWays(10, map);
        System.out.println(i);

        int i2 = getClimbingWays(10);
        System.out.println(i2);
    }

}
