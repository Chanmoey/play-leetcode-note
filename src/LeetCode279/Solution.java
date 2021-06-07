package LeetCode279;

import java.util.ArrayDeque;
import java.util.Deque;

class Pair<K, V> {
    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class Solution {
    public int numSquares(int n) {
        Deque<Pair<Integer, Integer>> q = new ArrayDeque<>();
        q.addLast(new Pair<>(n, 0));

        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        while (!q.isEmpty()) {
            int num = q.getFirst().getKey();
            int step = q.getFirst().getValue();
            q.removeFirst();

            for (int i = 1; ; i++) {
                int a = num - i * i;
                if (a < 0) {
                    break;
                }
                if (a == 0) {
                    return step + 1;
                }
                if (!visited[a]) {
                    q.addLast(new Pair<>(a, step + 1));
                    visited[a] = true;
                }
            }
        }

        return 0;
    }
}