package Leetcode215;

import java.util.PriorityQueue;

/**
 * 使用优先队列（最大堆）
 *
 * @author Chanmoey
 * @date 2022年02月23日
 */
class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            maxHeap.add(num);
        }

        for (int i = 1; i < k; i++) {
            maxHeap.poll();
        }

        // 题目保证 k <= nums.length，所以直接 poll() 不会导致NPE。
        return maxHeap.poll();
    }
}
