package LeetCode128;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年07月06日
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>(2 * nums.length);
        int max = 1;
        for (int n : nums) {
            if (map.containsKey(n - 1)) {
                map.put(n, map.get(n - 1) + 1);
                max = Math.max(max, map.get(n));
            } else {
                map.put(n, 1);
            }
        }

        return max;
    }
}