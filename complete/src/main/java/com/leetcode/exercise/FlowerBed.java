package com.leetcode.exercise;

public class FlowerBed {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || n == 0) return !(n > 0);
        int prev = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if ((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    n--;
                    if (n == 0) return true;
                }
            }
        }
        return false;
    }
}
