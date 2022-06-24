package LeetCode1354;

import java.util.*;

/**
 * @author Chanmoey
 * @date 2022年06月24日
 */
class Solution {
    public boolean isPossible(int[] target) {
        long sum = 0;
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int j : target) {
            sum += j;
            priorityQueue.add((long) j);
        }

        while (!priorityQueue.isEmpty()) {
            long cur = priorityQueue.poll();
            if (cur == 1) {
                continue;
            }

            if (sum == cur || cur <= sum - cur) {
                return false;
            }

            sum -= cur;
            cur %= sum;

            if (sum == 1) {
                cur = 1;
            }
            priorityQueue.add(cur);
            sum += cur;
        }

        return true;
    }
}
