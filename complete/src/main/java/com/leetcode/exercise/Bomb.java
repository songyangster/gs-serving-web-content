package com.leetcode.exercise;

public class Bomb {
    public int maxKilledEnemies(char[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    int count = 0;
                    int c = i - 1;
                    while (c >= 0 && grid[c][j] != 'W') {
                        if (grid[c][j] == 'E') count++;
                        c--;
                    }
                    c = i + 1;
                    while (c < grid.length && grid[c][j] != 'W') {
                        if (grid[c][j] == 'E') count++;
                        c++;
                    }
                    c = j - 1;
                    while (c >= 0 && grid[i][c] != 'W') {
                        if (grid[i][c] == 'E') count++;
                        c--;
                    }
                    c = j + 1;
                    while (c < grid[0].length && grid[i][c] != 'W') {
                        if (grid[i][c] == 'E') count++;
                        c++;
                    }
                    if (count > max) max = count;
                }
            }
        }
        return max;
    }
}
