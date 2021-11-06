package LeetCode260;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public int[] singleNumber(int[] nums) {

        if (nums.length == 2) {
            return nums;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, 1);
            }
        }

        int[] res = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res[index++] = entry.getKey();
        }

        return res;
    }
}
