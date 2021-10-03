package LeetCode347;

//import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Pair implements Comparable{
    Integer first;
    Integer second;

    public Pair(Integer first, Integer secont) {
        this.first = first;
        this.second = secont;
    }

    public Integer getFirst() {
        return first;
    }

    public Integer getSecond() {
        return second;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Pair)){
            throw new RuntimeException("Not Pair object");
        }
        Pair pair = (Pair) o;
        if (this.first > pair.getFirst()) {
            return 1;
        }
        return -1;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // key: element, value: frequent
        assert k > 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int e : nums) {
            freq.put(e, freq.getOrDefault(e, 0) + 1);
        }
        assert k <= freq.size();
        // Pair<frequent, element>
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> m : freq.entrySet()) {

            if (pq.size() == k) {
                if (m.getValue() > pq.peek().getFirst()) {
                    pq.remove();
                    pq.add(new Pair(m.getValue(), m.getKey()));
                }
            } else {
                pq.add(new Pair(m.getValue(), m.getKey()));
            }
        }

        int[] res = new int[k];
        int index = 0;
        while (!pq.isEmpty()) {
            res[index++] = pq.remove().getSecond();
        }

        return res;
    }
}
