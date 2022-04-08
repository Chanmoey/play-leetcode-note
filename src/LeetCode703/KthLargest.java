package LeetCode703;

import java.util.PriorityQueue;

/**
 * @author Chanmoey
 * @date 2022年04月08日
 */
class KthLargest {

    private final int k;
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            minHeap.add(num);
        }
    }

    public int add(int val) {
        /**
         * this.minHeap.add(val);
         *         int[] temp = new int[k - 1];
         *         int ret = -1;
         *         for (int i = 0; i < k; i++) {
         *             if (i == k - 1) {
         *                 ret = this.minHeap.remove();
         *                 break;
         *             }
         *             temp[i] = this.minHeap.remove();
         *         }
         *
         *         for (int j : temp) {
         *             this.minHeap.add(j);
         *         }
         *
         *         return ret;
         */
        this.minHeap.add(val);
        while (this.minHeap.size() > this.k) {
            this.minHeap.poll();
        }

        return this.minHeap.peek();
    }
}
