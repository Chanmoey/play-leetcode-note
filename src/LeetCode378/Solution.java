package LeetCode378;

import java.util.PriorityQueue;

/**
 * @author Chanmoey
 * @date 2022年08月02日
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                pq.add(anInt);
            }
        }

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }

//        assert !pq.isEmpty();
        return pq.poll();
    }
}
