package com.leetcode.exercise.datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

class MyHashMap {
    private Bucket[] buckets;
    private int c = 16;

    public MyHashMap() {
        buckets = new Bucket[c];
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new Bucket();
        }
        buckets[index].put(key, value);
    }

    public int get(int key) {
        int index = getIndex(key);
        if (buckets[index] == null) return -1;
        return buckets[index].get(key);
    }

    public void remove(int key) {
        int index = getIndex(key);
        if (buckets[index] == null) return;
        buckets[index].remove(key);
    }

    private int getIndex(int key) {
        return key % c;
    }

    private static class Bucket {
        private LinkedList<Entry> bucketList;

        public Bucket() {
            bucketList = new LinkedList<>();
        }

        public void put(int key, int value) {
            for (Entry entry : bucketList) {
                if (key == entry.getKey()) {
                    entry.setValue(value);
                    return;
                }
            }
            bucketList.add(new Entry(key, value));
        }

        public int get(int key) {
            for (Entry entry : bucketList) {
                if (key == entry.getKey()) {
                    return entry.getValue();
                }
            }
            return -1;
        }

        public void remove(int key) {
            Iterator<Entry> iterator = bucketList.iterator();
            while (iterator.hasNext()) {
                Entry entry = iterator.next();
                if (key == entry.getKey()) {
                        iterator.remove();
                        return;
                }
            }
        }

        public LinkedList<Entry> getBucketList() {
            return bucketList;
        }

        @Override
        public String toString() {
            return "Bucket{" +
                    "bucketList=" + bucketList +
                    '}';
        }
    }

    private static class Entry {
        private Integer key;
        private Integer value;

        public Entry(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry bucket = (Entry) o;
            return Objects.equals(key, bucket.key) && Objects.equals(value, bucket.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        @Override
        public String toString() {
            return "Bucket{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
