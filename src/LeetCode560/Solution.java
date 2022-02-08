package LeetCode560;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年02月08日
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>(2 * nums.length);
        int sum = 0;
        prefixSum.put(0, 1);
        int ans = 0;
        for (int num : nums) {
            sum += num;
            if (prefixSum.containsKey(sum - k)) {
                ans += prefixSum.get(sum - k);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
