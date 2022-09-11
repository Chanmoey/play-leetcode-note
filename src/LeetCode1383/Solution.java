package LeetCode1383;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Chanmoey
 * @date 2022年09月11日
 */
class Solution {

    private record Engineer(int speed, int efficiency) {
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        List<Engineer> engineers = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            engineers.add(new Engineer(speed[i], efficiency[i]));
        }

        engineers.sort((a, b) -> b.efficiency - a.efficiency);

        PriorityQueue<Engineer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.speed));

        long totalSpeed = 0;
        long totalPerformance = 0;

        for (int i = 0; i < n; i++) {
            if (minHeap.size() >= k) {
                totalSpeed -= minHeap.remove().speed;
            }
            minHeap.add(engineers.get(i));
            totalSpeed += engineers.get(i).speed;

            totalPerformance = Math.max(totalPerformance, totalSpeed * engineers.get(i).efficiency);
        }

        return (int) (totalPerformance % 1000000007);
    }
}






















