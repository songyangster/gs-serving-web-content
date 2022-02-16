package com.leetcode.exercise;

public class LongestCommonString {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return "";
        StringBuffer buffer = new StringBuffer();
        int i = 0;
        while (true) {
            Character c = null;
            for (String str : strs) {
                if (str == null || str.isEmpty() || i > str.length() - 1) return buffer.toString();
                if (c == null) {
                    c = str.charAt(i);
                } else {
                    if (str.charAt(i) != c) return buffer.toString();
                }
            }
            buffer.append(c);
            i++;
        }
    }
}
