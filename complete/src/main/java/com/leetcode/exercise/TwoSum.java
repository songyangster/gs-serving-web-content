package com.leetcode.exercise;

import java.util.*;

public class TwoSum {
    Map<Integer, Integer> values;

    public TwoSum() {
        values = new HashMap<>();
    }

    public void add(int number) {
        if (!values.containsKey(number)) {
            values.put(number, 0);
        }
        values.put(number, values.get(number) + 1);
    }

    public boolean find(int value) {
        boolean found = false;
        for (Integer key : values.keySet()) {
            int reminder = value - key;
            if (reminder != key) {
                if (values.containsKey(reminder)) return true;
            } else {
                if(values.get(key) >= 2) return true;
            }
        }
        return false;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j= i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return new int[0];
    }
}
