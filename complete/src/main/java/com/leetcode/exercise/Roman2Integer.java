package com.leetcode.exercise;

import java.util.*;

public class Roman2Integer {
    public int romanToInt(String s) {
        int val = 0;
        Map<String, Integer> charVal = new HashMap<String, Integer>(){
            {
                put("I", 1); put("V", 5); put("X", 10); put("L", 50); put("C", 100); put("D", 500); put("M", 1000);
            }};
        Map<String, Integer> pairVal = new HashMap<String, Integer>(){
            {
                put("IV", 4); put("IX", 9); put("XL", 40); put("XC", 90); put("CD", 400); put("D", 500); put("CM", 900);
            }};

        int i = 0;
        while (i < s.length()) {
            String part = i < s.length() - 1 ? s.substring(i, i+2) : null;
            if (part != null && pairVal.containsKey(part)) {
                val += pairVal.get(part);
                i++;
            } else {
                val += charVal.get(s.substring(i, i+1));
            }
            i ++;
        }
        return val;
    }

    private static Map<Integer, String> numRomanMap = new HashMap<Integer, String>(){
        {
            put(0, ""); put(1, "I"); put(2, "II"); put(3, "III"); put(4, "IV");
            put(5, "V"); put(6, "VI"); put(7, "VII"); put(8, "VIII"); put(9, "IX");
            put(10, "X"); put(20, "XX"); put(30, "XXX"); put(40, "XL");
            put(50, "L"); put(60, "LX"); put(70, "LXX"); put(80, "LXXX"); put(90, "XC");
            put(100, "C"); put(200, "CC"); put(300, "CCC"); put(400, "CD");
            put(500, "D"); put(600, "DC"); put(700, "DCC"); put(800, "DCCC"); put(900, "CM");
            put(1000, "M"); put(2000, "MM"); put(3000, "MMM");
        }};

    public String intToRoman(int num) {
        if (num <= 0) return null;
        List<String> romanList = new ArrayList<>();
        int base = 10;
        while (num > 0) {
            int reminder = num % base;
            romanList.add(numRomanMap.get(reminder));
            num -= reminder;
            base *= 10;
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = romanList.size() -1; i >= 0; i--) {
            buffer.append(romanList.get(i));
        }
        return buffer.toString();
    }
}
