package com.leetcode.exercise;

public class ClimbStairs {

    public int climbStairs(int n) {
        Integer[] store = null;
        return fun(n, store);
    }

    private int fun(int n, Integer[] store) {
        if (n == 0) return 0;
        if (store == null) store = new Integer[n];
        int count = 0;
        if (n > 2) {
            count = (store[n - 2] != null ? store[n - 2] : fun(n-1, store)) + (store[n - 3] != null ? store[n - 3] : fun(n-2, store)); // index starts from 0
        } else {
            count = n == 2 ? 2 : 1;
        }
        if (store[n - 1] == null) store[n - 1] = count;
        return count;
    }
}
