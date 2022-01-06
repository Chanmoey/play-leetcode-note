package LeetCode1094;

import java.util.*;

/**
 * @author Chanmoey
 * @date 2022年01月06日
 */
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));

        if (trips[0][0] > capacity) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>(trips.length * 2);
        map.putIfAbsent(trips[0][2], trips[0][0]);
        capacity -= trips[0][0];

        for (int i = 1; i < trips.length; i++) {

            int position = trips[i][1];

            Iterator<Map.Entry<Integer, Integer>> entryIterator = map.entrySet().iterator();
            while (entryIterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = entryIterator.next();
                if (entry.getKey() <= position) {
                    capacity += entry.getValue();
                    entryIterator.remove();
                }
            }

            if (capacity < trips[i][0]) {
                return false;
            }

            map.put(trips[i][2], map.getOrDefault(trips[i][2], 0) + trips[i][0]);
            capacity -= trips[i][0];
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.carPooling(new int[][]{{9,3,6},{8,1,7},{6,6,8},{8,4,9},{4,2,9}}, 28));
    }
}
