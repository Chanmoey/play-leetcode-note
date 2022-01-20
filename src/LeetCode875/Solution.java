package LeetCode875;

import java.util.PriorityQueue;

/**
 *
 * 使用最大堆的思路，未完成。！！！
 *
 * @author Chanmoey
 * @date 2022年01月20日
 */
class Solution {

    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    public int minEatingSpeed(int[] piles, int h) {
        this.creatMaxHeap(piles);

        int k = h - piles.length;
        if (k == 0) {
            return this.maxHeap.remove();
        }

        int[] kMax = findKthMax(k + 1);
        // TODO 使用最大堆完成该题。

        return -1;
    }

    private void creatMaxHeap(int[] nums) {
        for (int num : nums) {
            this.maxHeap.offer(num);
        }
    }

    private int[] findKthMax(int k) {

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            if (this.maxHeap.isEmpty()) {
                break;
            }
            arr[i] = this.maxHeap.poll();
        }

        return arr;
    }
}
