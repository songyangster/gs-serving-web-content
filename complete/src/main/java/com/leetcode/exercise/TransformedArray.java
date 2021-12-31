package com.leetcode.exercise;

import java.util.ArrayList;
import java.util.List;

public class TransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        double medium = - (double) b / a / 2.0;
        boolean isAssending = a > 0;
        if (a == 0) {
            isAssending = b > 0;
        } else if (medium < nums[0]) {
            // Do Nothing
        } else if (medium > nums[nums.length - 1]) {
            isAssending = a < 0;
        } else {
            // rearrange wrt medium
            nums = sortByMedium(nums, medium);
        }

        int[] vals = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            vals[isAssending ? i : nums.length - 1 - i] = a * x * x + b * x + c;
        }
        return vals;
    }

    private int[] sortByMedium(int[] nums, double medium) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int element : nums) {
            if (element < medium) {
                left.add(element);
            } else {
                right.add(element);
            }
        }
        List<Integer> newList = new ArrayList<>();
        int l = left.size() - 1;
        int r = 0;
        while(l >= 0 || r < right.size()) {
            if ( (l >= 0 && r < right.size() && (medium - left.get(l)) < (right.get(r) - medium)) || r >= right.size()) {
                newList.add(left.get(l));
                l--;
            } else if (r < right.size()){
                newList.add(right.get(r));
                r++;
            }
        }

        for (int i = 0; i < newList.size(); i++) {
            nums[i] = newList.get(i);
        }
        return nums;
    }
}
