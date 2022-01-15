package LeetCode1345;

import java.util.*;

/**
 * @author Chanmoey
 * @date 2022年01月15日
 */
class Solution {
    public int minJumps(int[] arr) {

        if (arr.length == 1) {
            return 0;
        }

        int len = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>(len);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            map.computeIfAbsent(arr[i], key -> new ArrayList<>()).add(i);
        }

        queue.offer(0);
        visited.add(0);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                if (index == len - 1) {
                    return count;
                }

                if (index - 1 >= 0 && visited.add(index - 1)) {
                    queue.offer(index - 1);
                }

                if (index + 1 < len && visited.add(index + 1)) {
                    queue.offer(index + 1);
                }

                for (int ind : map.get(arr[index])) {
                    if (visited.add(ind)) {
                        queue.offer(ind);
                    }
                }

                map.get(arr[index]).clear();
            }
            count++;
        }

        return -1;
    }
}
