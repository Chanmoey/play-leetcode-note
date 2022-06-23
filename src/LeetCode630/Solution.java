package LeetCode630;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Chanmoey
 * @date 2022年06月23日
 */
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            minHeap.offer(course[0]);
            if (time > course[1]) {
                time -= minHeap.poll();
            }
        }

        return minHeap.size();
    }
}
