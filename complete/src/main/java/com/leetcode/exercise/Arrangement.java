package com.leetcode.exercise;

public class Arrangement {
    public int countArrangement(int n) {
        return 1 + perm(n);
    }

    int[] p = {0,1,2,2,3,1,2,1,3,2,2,1,3,1,2,2};
    private int perm(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return p[n] * perm(n - 1);
    }
}
