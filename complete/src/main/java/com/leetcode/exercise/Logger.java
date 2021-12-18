package com.leetcode.exercise;

import java.util.HashMap;
import java.util.Map;

public class Logger {
    private Map<String, Integer> messageMap;
    public Logger() {
        messageMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (message == null) return false;
        if (messageMap.containsKey(message)) {
            if (timestamp - messageMap.get(message) >= 10) {
                messageMap.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        } else {
            messageMap.put(message, timestamp);
            return true;
        }
    }
}
