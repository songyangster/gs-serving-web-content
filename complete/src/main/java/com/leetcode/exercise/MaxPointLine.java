package com.leetcode.exercise;

import java.util.HashMap;
import java.util.Map;

public class MaxPointLine {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length == 1) return 1;
        Map<Line, Integer> counts = new HashMap<>();
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j ++) {
                Line line = new Line(points[i], points[j]);
                if (line.isLine) {
                    if (!counts.containsKey(line)) {
                        counts.put(line, 0);
                    }
                    int value = counts.get(line) + 1;
                    counts.put(line, value);
                    if (value > max) max = value;
                }
            }
        }
        System.out.println(max);
        return (int) ((Math.sqrt(max * 2 + .25) + .5) + .5);
    }

    public static class Line {
        private int denominator;
        private int a;
        private int b;
        boolean isLine = true;

        public Line(int[] p1, int[] p2) {
            // x - [0] y - [1]
            denominator = p2[0] - p1[0];
            a = denominator == 0 ? p2[0] : p2[1] - p1[1];
            b = p2[0] * p1[1] - p1[0] * p2[1];
            if (denominator == 0 && a == 0) isLine = false;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return denominator == 0 ? true :
                    denominator * line.a == line.denominator * a && denominator * line.b == line.denominator * b ;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public String toString() {
            return denominator != 0 ? "y = " + ((float) a)/denominator + "x + " + ((float) b)/denominator : "x = " + a;
        }
    }
}
