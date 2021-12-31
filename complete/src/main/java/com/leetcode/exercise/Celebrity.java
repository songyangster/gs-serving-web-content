package com.leetcode.exercise;

import java.util.HashSet;
import java.util.Set;

public class Celebrity {
    public int findCelebrity(int n) {
        Set<Integer> candidates = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (knows(0, i) || i == 0 && knows(1, i)) {
                if(!candidates.contains(i) && isCelebrity(n, i)) return i;
                candidates.add(i);
            }
        }
        return -1;
    }

    private boolean isCelebrity(int n, int i) {
        for (int j = 0; j < n; j++) {
            if (j != i) {
                if (knows(i, j) || !knows(j, i)) return false;
            }
        }
        return true;
    }

    private boolean knows (int i, int j) {
        //ToDo to be implemented
        return true;
    }
}
