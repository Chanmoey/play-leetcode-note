package LeetCode460;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Chanmoey
 * @date 2023年01月31日
 */
class LFUCache {

    private static class Node {
        private Integer key;

        private Integer value;

        private Integer freq;

        private Integer time;

        public Integer getKey() {
            return key;
        }

        public Integer getFreq() {
            return freq;
        }

        public Integer getTime() {
            return time;
        }

        public void setFreq(Integer freq) {
            this.freq = freq;
        }

        public void setTime(Integer time) {
            this.time = time;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node(Integer key, Integer value, Integer time) {
            this.key = key;
            this.value = value;
            this.freq = 1;
            this.time = time;
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }

        @Override
        public boolean equals(Object obj) {

            if (obj instanceof Node node) {
                return key.equals(node.getKey());
            }

            return false;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", freq=" + freq +
                    ", time=" + time +
                    '}';
        }
    }

    private final Map<Integer, Node> cache;
    private final PriorityQueue<Node> queue;
    private int size;
    private final int capacity;
    private int timeCounter = 0;

    public LFUCache(int capacity) {
        this.cache = new HashMap<>();
        this.queue = new PriorityQueue<>((a, b) -> {
            if (a.getFreq().equals(b.getFreq())) {
                return a.getTime() - b.getTime();
            } else {
                return a.getFreq() - b.getFreq();
            }
        });
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {

        if (capacity == 0) {
            return -1;
        }

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            queue.remove(node);
            node.setFreq(node.getFreq() + 1);
            node.setTime(timeCounter++);
            queue.add(node);
            return node.getValue();
        }
        return -1;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            queue.remove(node);
            node.setValue(value);
            node.setTime(timeCounter++);
            node.setFreq(node.getFreq() + 1);
            queue.add(node);
        } else {
            if (size == capacity) {
                Node rem = queue.poll();
                cache.remove(rem.getKey());

                Node node = new Node(key, value, timeCounter++);
                cache.put(key, node);
                queue.offer(node);

            } else {
                Node node = new Node(key, value, timeCounter++);
                cache.put(key, node);
                queue.offer(node);
                size++;
            }
        }
    }
}
