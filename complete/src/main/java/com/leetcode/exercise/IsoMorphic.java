package com.leetcode.exercise;

import java.util.HashMap;
import java.util.Map;

public class IsoMorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        Map<Character, Character> charS2T = new HashMap<>();
        Map<Character, Character> charT2S = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (mismatch(charS2T, charS, charT)) return false;
            if (mismatch(charT2S, charT, charS)) return false;
        }
        return true;
    }

    private boolean mismatch(Map<Character, Character> charS2T, char char1, char char2) {
        if (charS2T.containsKey(char1)) {
            if (charS2T.get(char1) != char2) return true;
        } else {
            charS2T.put(char1, char2);
        }
        return false;
    }
}
