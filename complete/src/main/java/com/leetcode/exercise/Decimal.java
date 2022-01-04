package com.leetcode.exercise;

public class Decimal {
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty() || s.matches("e|E|\\.") || s.matches(".*(e|E)")) return false;
        String[] parts = s.split("e|E");
        if (parts.length > 2) return false;
        boolean isN = isNumber(parts[0], false);
        return parts.length > 1 ? isN && isNumber(parts[1], true) : isN;
    }

    boolean isNumber (String s, boolean isInt) {
        if (s == null || s.isEmpty() || s.matches("(\\+|-|)*(\\.)*")) return false;
        int decmalCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '+':
                    if (i != 0) return false;
                    break;
                case '-':
                    if (i != 0) return false;
                    break;
                case '.':
                    decmalCount++;
                    if (decmalCount > 1 || (isInt && decmalCount > 0)) return false;
                    break;
                default:
                    if (!Character.isDigit(c)) return false;
                    break;
            }
        }
        return true;
    }
}
