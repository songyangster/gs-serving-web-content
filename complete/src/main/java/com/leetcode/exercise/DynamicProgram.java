package com.leetcode.exercise;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DynamicProgram {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        int max = 0;
        dp[nums1.length - 1][nums2.length - 1] = 0;
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0 ; j--) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] =  (i != nums1.length - 1 && j !=nums2.length - 1) ? dp[i + 1][j + 1] + 1 : 1;
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > max) max = dp[i][j];
            }
        }
        return max;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j ++) {
                if (dp[i] && dict.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        dp[0] = 0;

        return 0;
    }
}
