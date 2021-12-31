package com.leetcode.exercise;

public class PartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int e: nums) {
            sum += e;
        }
        if (sum % k != 0) return false;
        int pSum = sum / k;
        return false;
    }
}
