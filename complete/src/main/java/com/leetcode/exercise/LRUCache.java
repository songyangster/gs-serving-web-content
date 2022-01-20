package com.leetcode.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class LRUCache {
    private int capacity;
    private Map<Integer, CacheNode<Integer, Integer>> cache;
    private int cacheSize;
    private CacheNode<Integer, Integer> head = null;
    private CacheNode<Integer, Integer> tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            CacheNode<Integer, Integer> node = cache.get(key);
            makeHead(node);
            return node.getValue();
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(!cache.containsKey(key)) {
            CacheNode<Integer, Integer> node = new CacheNode<>(key, value);
            cache.put(key, node);
            makeHead(node);
            cacheSize++;
            evict();
        } else {
            CacheNode<Integer, Integer> node = cache.get(key);
            node.setValue(value);
            makeHead(node);
        }
    }

    private void makeHead(CacheNode<Integer, Integer> node) {
        if (head == null) {
            head = node;
            tail = head;
        } else {
            if (tail.equals(node)) setTail();
            head.previous = node;
            node.next = head;
            node.previous = null;
            head = node;
        }
    }

    private void evict() {
        while(cacheSize > capacity) {
            cache.remove(tail.key);
            cacheSize--;
            setTail();
        }
    }

    private void setTail() {
        if (tail.previous != null) {
            tail.previous.next = null;
            tail = tail.previous;
        } else {
            tail = head;
        }
    }

    private static class CacheNode<K, V> {
        private K key;
        private V value;
        private CacheNode previous = null;
        private CacheNode next = null;

        public CacheNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public CacheNode getPrevious() {
            return previous;
        }

        public CacheNode getNext() {
            return next;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setPrevious(CacheNode previous) {
            this.previous = previous;
        }

        public void setNext(CacheNode next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CacheNode<?, ?> cacheNode = (CacheNode<?, ?>) o;
            return Objects.equals(key, cacheNode.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        @Override
        public String toString() {
            return "CacheNode{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
