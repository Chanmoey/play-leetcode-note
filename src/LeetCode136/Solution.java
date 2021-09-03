package LeetCode136;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length / 2 + 1);

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int single = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                single = entry.getKey();
            }
        }
        
        return single;
    }
}
