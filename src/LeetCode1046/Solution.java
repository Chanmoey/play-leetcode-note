package LeetCode1046;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Chanmoey
 * @date 2022年04月07日
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int max = maxHeap.poll();
            int noSuchMax = maxHeap.poll();
            int diff = max - noSuchMax;
            if (diff != 0) {
                maxHeap.add(diff);
            }
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.poll();
    }
}
