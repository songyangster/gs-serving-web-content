package com.leetcode.exercise;

import java.util.*;

public class ExclusiveTime {
    enum State{start, end}

    public int[] exclusiveTime(int n, List<String> logs) {
        Map<Integer, Integer> times = new HashMap<>();
        Stack<Entry> stack = new Stack<>();

        int timeLast = 0;
        boolean lastWasPop = false;
        for (String log : logs) {
            Entry entry = new Entry(log);
            if (entry.state.equals(State.start)) {
                if (!stack.isEmpty()) {
                    Entry pre = stack.peek();
                    int preId = pre.getId();
                    times.put(preId, (times.containsKey(preId) ? preId : 0 ) + entry.getTime() - timeLast);
                }
                stack.push(entry);
                lastWasPop = false;
            } else {
                Entry start = stack.pop();
                times.put(entry.getId(), (times.containsKey(entry.getId()) ? times.get(entry.getId() ): 0 ) + entry.getTime() - timeLast + (lastWasPop ? 0 :1));
                lastWasPop = true;
            }
            timeLast = entry.getTime();
        }
        int[] vals = new int[times.size()];
        ArrayList<Integer> list = new ArrayList<>(times.keySet());
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            vals[i] = times.get(i);
        }
        return vals;
    }

    private static class Entry {
        private State state;
        private int id;
        private int time;
        private int duration = 0;

        public Entry(String s) {
            String parts[] = s.split(":");
            id = Integer.parseInt(parts[0]);
            state = State.valueOf(parts[1]);
            time = Integer.parseInt(parts[2]);
        }

        public State getState() {
            return state;
        }

        public int getId() {
            return id;
        }

        public int getTime() {
            return time;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public void setTime(int time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "state=" + state +
                    ", id=" + id +
                    ", time=" + time +
                    '}';
        }
    }
}
