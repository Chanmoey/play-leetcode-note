package LeetCode1962;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * O(nlog(n))
 * @author Chanmoey
 * @date 2022年12月28日
 */
class Solution {
    public int minStoneSum(int[] piles, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Arrays.stream(piles).forEach(maxHeap::add);

        while (k > 0) {
            int max = maxHeap.poll();
            maxHeap.add(floor(max));
            k--;
        }

        return maxHeap.stream().reduce(0, Integer::sum);
    }

    private int floor(int num) {
        if (num % 2 == 0) {
            return num / 2;
        }

        return num / 2 + 1;
    }
}