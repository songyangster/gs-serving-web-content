package com.leetcode.exercise;

public class StringOp {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() !=  s1.length() + s2.length())  return  false;
        if (s3.isEmpty()) return true;

        char leading = s3.charAt(0);

        if (!s1.isEmpty() && s1.charAt(0) == leading) {
            boolean is = s2.isEmpty() || s3.length() == 1 || isInterleave(s1.substring(1), s2, s3.substring(1));
            if (is) return true;
        }

        if (!s2.isEmpty() && s2.charAt(0) == leading) {
            boolean is = s1.isEmpty() || s3.length() == 1 || isInterleave(s1, s2.substring(1), s3.substring(1));
            if (is) return true;
        }
        return false;
    }

}
