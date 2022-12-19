package LeetCode677;

import java.util.HashMap;
import java.util.Map;

/**
 * 错了，忘记考虑重复添加的操作了，比如apple 3，然后再添加apple 2.
 * @author Chanmoey
 * @date 2022年12月13日
 */
class MapSum {

    private static class Node {
        int count;
        Map<Character, Node> next;

        public Node(int count) {
            this.count = count;
            this.next = new HashMap<>();
        }

        public Node() {
            this(0);
        }

        public void add(int nextCount) {
            this.count += nextCount;
        }
    }

    private final Node root;

    public MapSum() {
        this.root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = this.root;
        for (char c : key.toCharArray()) {
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new Node(0));
            }
            cur = cur.next.get(c);
            cur.add(val);
        }
    }

    public int sum(String prefix) {
        Node cur = this.root;
        for (char c : prefix.toCharArray()) {
            if (!cur.next.containsKey(c)) {
                return 0;
            }
            cur = cur.next.get(c);
        }

        return cur.count;
    }
}
