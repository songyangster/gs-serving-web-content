package com.leetcode.exercise;

public class BulbSwitcher {
    public int bulbSwitch(int n) {
        int val = 0;
        for (int i = 1; i < n; i++) {
            int jc = 0;
            for (int j = 1; j < n; j++) {
                if (j % i == 0) {
                    jc++;
                }
            }
            if (jc % 2 == 0) val++;
        }
        return val;
    }
}
