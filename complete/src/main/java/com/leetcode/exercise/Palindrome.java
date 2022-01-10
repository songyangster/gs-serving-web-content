package com.leetcode.exercise;

import java.util.*;

public class Palindrome {
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0) x = - x;
        List<Integer> digits = new ArrayList<>();
        while (x > 0) {
            int mod = x % 10;
            digits.add(mod);
            x = (int) x / 10;
        }

        for (int i = 0; i <=  digits.size()/2; i++){
            if (digits.get(i) != digits.get(digits.size() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        char[] chars = s.toCharArray();
        LinkedList<PUnit> pUnites = new LinkedList<>();
        //Initialize
        for (int i = 0; i < chars.length; i++) {
            pUnites.add(new PUnit(chars, i, false));
            if (i + 1 < chars.length && chars[i + 1] == chars[i]) pUnites.add(new PUnit(chars, i, true));
        }

        Iterator<PUnit> iterator = pUnites.iterator();
        int max = 1;
        PUnit maxUnit = pUnites.get(0);
        while(iterator.hasNext()) {
            PUnit pUnit = iterator.next();
            while (pUnit.expand()) {
            }
            if (pUnit.getLength() > max) {
                maxUnit = pUnit;
                max = pUnit.getLength();
            }
        }

        return s.substring(maxUnit.getStart(), maxUnit.getEnd() + 1);
    }

    private static class PUnit {
        private char[] chars;
        int upper = 0;
        private int center;
        private int dupChar = 0;
        private int radius = 0;

        public PUnit(char[] chars, int center, boolean isDouble) {
            this.chars = chars;
            upper = chars.length -1;
            this.center = center;
            this.dupChar = isDouble ? 1 : 0;
        }

        boolean expand() {
            if (center - radius > 0 && center + radius + dupChar < upper && chars[center - radius - 1] == chars[center + dupChar + radius + 1]) {
                radius++;
                return true;
            } else {
                return false;
            }
        }

        public int getStart() {
            return center - radius;
        }

        public int getEnd() {
            return center + radius + dupChar;
        }

        public int getLength() {
            return 2 * radius + dupChar + 1;
        }

        @Override
        public String toString() {
            return "(" + (center - radius) + "," + (dupChar + center + radius) + ")";
        }
    }

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.isEmpty()) return 0;
        int val = 1;
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        return findPair(list);
    }

    int findPair(LinkedList<Character> list) {
        if (list.size() <= 1) return list.size();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        boolean touched = true;
        boolean found = false;
        while (touched && !list.isEmpty()) {
            touched = false;
            Character cl = list.peekFirst();
            if (!left.contains(cl)) {
                cl = list.removeFirst();
                if (right.contains(cl)) {
                    Character rs = right.pop();
                    while (rs != null && rs != cl) {
                        list.addLast(rs);
                        rs = right.isEmpty() ? null : right.pop();
                    }
                    found = true;
                    break;
                } else {
                    left.push(cl);
                }
                touched = true;
            }

            if (list.size() == 0) return 0;
            Character cr = list.peekLast();
            if (!right.contains(cr)) {
                cr = list.removeLast();
                if (left.contains(cr)) {
                    Character ls = left.pop();
                    while (ls != null && ls != cr) {
                        list.addFirst(ls);
                        ls = left.isEmpty() ? null : left.pop();
                    }
                    found = true;
                    break;
                } else {
                    right.push(cr);
                }
                touched = true;
            }
        }

        return found ? findPair(list) + 2 : 1;
    }
}
