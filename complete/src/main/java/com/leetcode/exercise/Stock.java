package com.leetcode.exercise;

public class Stock {
    public int maxProfit(int[] prices) {
        int maxDiff = 0;
        int max = 0;
        int min = 0;

        int[] temp = new int[prices.length];
        while(temp.length > 1) {
            int[] temp2 = new int[temp.length -1];
            for (int i = 0; i < temp.length - 1; i++) {
                int iPrice = i + prices.length - temp.length;
                temp2[i] = temp[i] + prices[iPrice + 1] - prices[iPrice];
                if (temp2[i] > maxDiff) maxDiff = temp2[i];
            }
            temp = temp2;
        }

        return maxDiff;
    }
}
