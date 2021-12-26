package com.leetcode.exercise;

import java.util.*;
import java.util.stream.IntStream;

public class SubArray {
    int[] nums;

    public int maxSubArray(int[] nums) {
        this.nums = nums;
        return findMax(0, nums.length - 1);
    }

    int findMax(int i, int j) {
        if (i > j) return Integer.MIN_VALUE;
        if (i == j) return nums[i];
        int mid = (int) (i + j)/2;
        int maxLeft = findMax(i, mid);
        int maxRight = findMax(mid + 1, j);

        int maxLeftFromMid = Integer.MIN_VALUE;
        int runningSum = 0;
        for (int p = mid; p >= i; p--) {
            runningSum += nums[p];
            if (runningSum > maxLeftFromMid) maxLeftFromMid = runningSum;
        }

        int maxRightFromMid = Integer.MIN_VALUE;
        runningSum = 0;
        for (int p = mid + 1; p <= j; p++) {
            runningSum += nums[p];
            if (runningSum > maxRightFromMid) maxRightFromMid = runningSum;
        }

        return Math.max(Math.max(maxLeft, maxRight),
                ((maxLeftFromMid > 0 || maxRightFromMid > 0) ? (maxLeftFromMid > 0 ? maxLeftFromMid : 0) + (maxRightFromMid > 0 ? maxRightFromMid : 0) : Integer.MIN_VALUE));
    }

    public int maxSubArrayGreedy(int[] nums) {
        int max = Integer.MIN_VALUE;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            current = Math.max(current + nums[i], nums[i]);
            max = Math.max(max, current); // find max in dp
        }
        return max;
    }

    public int maxSubArrayRecursion(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        int maxSum = Integer.MIN_VALUE;
        int iRight = 0;
        int iLeft = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxSum) {
                maxSum = nums[i];
                iLeft = i;
                iRight = i;
            }
        }
        int[] temp = nums;
        while(temp.length > 1) {
            int[] temp2 = new int[temp.length -1];
            for (int i = 0; i < temp.length - 1; i++) {
                int iNums = i + nums.length - temp.length +1;
                temp2[i] = temp[i] + nums[iNums];
                if (temp2[i] > maxSum) {
                    maxSum = temp2[i];
                    iLeft = i;
                    iRight = iNums;
                }
            }
            temp = temp2;
        }

        Integer[] array =  IntStream.range(iLeft, iRight + 1)
                .mapToObj(i -> nums[i])
                .toArray(Integer[]::new);

        System.out.println(Arrays.asList(array));
        return maxSum;
    }
}
