package com.leetcode.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> val = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int count = 1;
        int i1 = 0, i2 = 0;
        val.add(Arrays.asList(nums1[i1], nums2[i2]));
        while (count < k && (i1 < nums1.length || i2 < nums2.length)) {
            if (i1 < nums1.length - 1 && i2 < nums2.length -1) {
                if ((nums1[i1 + 1] + nums2[i2]) < (nums1[i1] + nums2[i2 + 1]) || (nums1[i1 + 1] + nums2[i2]) == (nums1[i1] + nums2[i2])) {
                    i1++;
                } else {
                    i2++;
                }
            } else if (i2 >= nums2.length - 1) {
                i1++;
            } else if (i1 >= nums1.length - 1) {
                i2++;
            } else {
                System.out.println("Should not reach here!!!!!");
            }
            val.add(Arrays.asList(nums1[i1], nums2[i2]));
            count++;
        }

        return val;
    }
}
