package com.leetcode.exercise;

import java.util.*;

class LFUCache {
    private int capacity;
    Map<Integer, Entry> cache;
    PriorityQueue<Entry> queue;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        queue = new PriorityQueue<>(capacity);
    }

    public int get(int key) {
        return cache.containsKey(key) ? cache.get(key).getVal() : -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.get(key).increment();
        } else {
            Entry entry = new Entry(key, value);
            if (cache.size() < capacity) {
                cache.put(key, entry);
            } else {
                queue.poll();
            }
        }
    }

    private static class Entry implements Comparable {
        private int key;
        private int val;
        private int count;

        public Entry(int key, int val) {
            this.key = key;
            this.val = val;
            count = 1;
        }

        public void increment () {
            count++;
        }

        public int getKey() {
            return key;
        }

        public int getVal() {
            return val;
        }

        public int getCount() {
            return count;
        }

        @Override
        public int compareTo(Object o) {
            if (this.count == ((Entry) o).count) return 0;
            return this.count > ((Entry) o).count ? 1 : -1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return key == entry.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", val=" + val +
                    ", count=" + count +
                    '}';
        }
    }
}
