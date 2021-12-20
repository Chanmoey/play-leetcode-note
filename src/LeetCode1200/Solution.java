package LeetCode1200;

import java.util.*;

/**
 * @author Chanmoey
 * @date 2021年12月20日 15:08
 * @description
 */
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        Map<Integer, List<List<Integer>>> map = new HashMap<>(arr.length);

        int minAbs = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            int abs = arr[j] - arr[i];
            minAbs = Math.min(minAbs, abs);

            List<Integer> temp = new ArrayList<>();
            temp.add(arr[i]);
            temp.add(arr[j]);

            if (map.containsKey(abs)) {
                map.get(abs).add(temp);
            } else {
                map.put(abs, new ArrayList<>());
                map.get(abs).add(temp);
            }
        }

        return map.get(minAbs);
    }
}
