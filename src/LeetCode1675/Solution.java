package LeetCode1675;

import java.util.PriorityQueue;

/**
 * @author Chanmoey
 * @date 2022年02月19日
 */
class Solution {
    public int minimumDeviation(int[] nums) {

        // 传入比较器，以便构建最大堆。
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                nums[i] = nums[i] * 2;
            }
            minValue = Math.min(minValue, nums[i]);
            maxHeap.add(nums[i]);
        }

        int diff = Integer.MAX_VALUE;
        int maxValue;
        while (maxHeap.peek() % 2 == 0) {
            maxValue = maxHeap.remove();
            diff = Math.min(diff, maxValue - minValue);
            minValue = Math.min(minValue, maxValue / 2);
            maxHeap.add(maxValue / 2);
        }

        return Math.min(diff, maxHeap.peek() - minValue);
    }
}
