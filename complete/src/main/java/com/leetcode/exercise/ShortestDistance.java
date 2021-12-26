package com.leetcode.exercise;

public class ShortestDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int min = wordsDict.length;
        String current = null;
        Boolean isWord1 = null;
        Integer last = null;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                if (current != null) {
                    if (!current.equals(word1) && !(last == null)) {
                        if (i - last < min) min = i - last;
                    }
                }
                last = i;
                current = word1;
            } else
            if (wordsDict[i].equals(word2)) {
                if (current != null) {
                    if (!current.equals(word2) && !(last == null)) {
                        if (i - last < min) min = i - last;
                    }
                }
                last = i;
                current = word2;
            }
        }
        return min;
    }
}
