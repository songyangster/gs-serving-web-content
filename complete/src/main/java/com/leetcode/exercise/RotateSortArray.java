package com.leetcode.exercise;

public class RotateSortArray {
    int bound = Integer.MIN_VALUE;
    public int search(int[] nums, int target) {
        findEnd(nums, 0, nums.length);
        return bound;
    }

    private int findEnd(int[] nums, int left, int right) {
        if (nums[left] < nums[right]) return 0;
        int medium = (left + right) /2;
        while (left <= right) {
            if (nums[left] < nums[medium]) {
                left = medium;
            } else {
                right = medium + 1;
            }
        }
        return medium;
    }
}
