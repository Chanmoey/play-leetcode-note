package LeetCode981;

import java.util.*;

class TimeMap {

    private static class Value implements Comparable<Value> {
        private final String value;
        private final int timestamp;

        public Value(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }

        @Override
        public int compareTo(Value o) {
            // 倒序排序
            return o.timestamp - this.timestamp;
        }
    }

    private final Map<String, PriorityQueue<Value>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new PriorityQueue<>()).add(new Value(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        PriorityQueue<Value> queue = map.get(key);
        List<Value> temp = new ArrayList<>();
        String res = "";

        while (!queue.isEmpty()) {
            if (queue.peek().timestamp > timestamp) {
                temp.add(queue.remove());
            } else {
                res = queue.peek().value;
                break;
            }
        }

        queue.addAll(temp);
        return res;
    }
}
