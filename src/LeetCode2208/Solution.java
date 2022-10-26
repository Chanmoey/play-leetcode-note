package LeetCode2208;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Chanmoey
 * @date 2022年10月26日
 */
class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0.0;
        for (int num : nums) {
            sum += num;
            queue.add((double) num);
        }

        double half = sum / 2;
        double reduce = 0.0;
        int op = 0;
        while (reduce < half) {
            op++;
            reduce += queue.peek() / 2;
            queue.add(queue.remove() / 2);
        }

        return op;
    }
}
