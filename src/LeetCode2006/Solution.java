package LeetCode2006;

import java.util.HashMap;

class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        int res = 0;
        for (int i : nums) {
            res += map.getOrDefault(k+i, 0) + map.getOrDefault(k-i, 0);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        return res;
    }
}
