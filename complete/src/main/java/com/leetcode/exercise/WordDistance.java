package com.leetcode.exercise;

import java.util.*;

public class WordDistance {
    String[] wordDict;

    public WordDistance(String[] wordsDict) {
        this.wordDict = wordsDict;
        wordPositions = new HashMap<>();
        fillPositions();
    }

    Map<String, LinkedList<Integer>> wordPositions;
    private void fillPositions() {
        for (int i = 0; i < wordDict.length; i++) {
            String word = wordDict[i];
            if (!wordPositions.containsKey(word)) {
                wordPositions.put(word, new LinkedList<>());
            }
            wordPositions.get(word).add(i);
        }
    }

    enum WORD {ONE, TWO}
    public int shortest(String word1, String word2) {
        Map<WORD, WordPos> wordWordPosMap = new HashMap<>();
        int i = 0;
        String[] words = new String[]{word1, word2};
        for (WORD word: WORD.values()) {
            String ws = words[i++];
            LinkedList<Integer> list = wordPositions.get(ws);
            if (list == null || list.isEmpty()) return 0;
            wordWordPosMap.put(word, new WordPos(list));
        }

        WORD lw = WORD.TWO;
        WORD hw = WORD.ONE;
        if (wordWordPosMap.get(WORD.ONE).current < wordWordPosMap.get(WORD.TWO).current) {
            lw = WORD.ONE;
            hw = WORD.TWO;
        }
        int min = wordWordPosMap.get(hw).current - wordWordPosMap.get(lw).current;

        while (true) {
            WordPos wordPos = wordWordPosMap.get(lw);
            if (!wordPos.iterate()) break;
            if (wordPos.getCurrent() > wordWordPosMap.get(hw).getCurrent()) {
                WORD temp = lw;
                lw = hw;
                hw = temp;
            }
            min = Math.min(wordWordPosMap.get(hw).getCurrent() - wordWordPosMap.get(lw).getCurrent(), min);
        }
        return min;
    }

    private static class WordPos {
        Iterator<Integer> iterator;
        int current;

        public WordPos(LinkedList<Integer> positions) {
            iterator = positions.iterator();
            current = iterator.next();
        }

        public boolean iterate() {
            if (iterator.hasNext()) {
                current = iterator.next();
                return true;
            } else {
                return false;
            }
        }

        public int getCurrent() {
            return current;
        }
    }

    //        distances = new HashMap();
//        cleanDict();
//        fillMap();

    public int shortestDistanceMap(String word1, String word2) {
        Integer val = this.distances.get(new Pair(word1, word2));
        return val != null ? val : 0;
    }

    private void cleanDict() {
        List<String> list = new ArrayList<>();
        String last = "";
        for (int i = 0; i < wordDict.length; i++) {
            if (!last.equals(wordDict[i])) {
                last = wordDict[i];
                list.add(last);
            }
        }
        wordDict = list.toArray(new String[list.size()]);
    }

    Map<Pair, Integer> distances;
    private void fillMap() {
        for (int i = 0; i < wordDict.length; i++) {
            for (int j = i + 1; j < wordDict.length; j++) {
                Pair pair = new Pair(wordDict[i], wordDict[j]);
                if (!distances.containsKey(pair) || distances.get(pair) > j - i) {
                         distances.put(pair, j - i);
                }
            }
        }
    }

    public static class Pair {
        Set<String> words;

        public Pair (String word1, String word2) {
            words = new HashSet<>();
            words.add(word1);
            words.add(word2);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(words, pair.words);
        }

        @Override
        public int hashCode() {
            return Objects.hash(words);
        }
    }

    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length <= 1) return true;
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < order.length() ; i++) {
            dict.put(order.charAt(i), order.length() - i);
        }

        for (int j = 1; j < words.length; j++) {
            if (compareWords(words[j - 1], words[j], dict) < 0) return false;
        }
        return true;
    }

    private int compareWords(String a, String b, Map<Character, Integer> dict) {
        if (a == null && b == null) return 0;
        if (b == null) return 1;
        if (a == null) return -1;
        int index = 0;
        while (index < a.length() || index < b.length()) {
            if (index > a.length() -1 || index < b.length() && dict.get(a.charAt(index)) > dict.get(b.charAt(index))) {
                return 1;
            } else if (index > b.length() -1 || index < a.length() && dict.get(a.charAt(index)) < dict.get(b.charAt(index))) {
                return -1;
            } else {
                index++;
            }
        }
        return 0;
    }
}
